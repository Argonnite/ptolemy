/* A parser for PlotML (Plot Markup Language) supporting PlotBoxML commands.

 Copyright (c) 1998-1999 The Regents of the University of California.
 All rights reserved.
 Permission is hereby granted, without written agreement and without
 license or royalty fees, to use, copy, modify, and distribute this
 software and its documentation for any purpose, provided that the above
 copyright notice and the following two paragraphs appear in all copies
 of this software.

 IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY
 FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES
 ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
 THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
 SUCH DAMAGE.

 THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY WARRANTIES,
 INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
 PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
 CALIFORNIA HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES,
 ENHANCEMENTS, OR MODIFICATIONS.

                                        PT_COPYRIGHT_VERSION_2
                                        COPYRIGHTENDKEY

@ProposedRating Red (eal@eecs.berkeley.edu)
@AcceptedRating Red (cxh@eecs.berkeley.edu)
*/

package ptolemy.plot.plotml;

// Ptolemy imports.
import ptolemy.plot.PlotBox;

// Java imports.
import java.util.Hashtable;
import java.util.Stack;
import java.io.InputStream;
import java.io.FileInputStream;
import java.net.URL;

// XML imports.
import com.microstar.xml.*;


//////////////////////////////////////////////////////////////////////////
//// PlotBoxMLParser
/**
This class constructs a plot from specifications
in PlotML (Plot Markup Language), which is an XML language.
This class supports only the subset that applies to the PlotBox base class.
It ignores all other elements in the DTD.
The class contains an instance of the Microstar &AElig;lfred XML
parser and implements callback methods to interpret the parsed XML.
The way to use this class is to construct it with a reference to
a PlotBox object and then call its parse() method.

@author Edward A. Lee
@version $Id: PlotBoxMLParser.java,v 1.9 1999/08/19 01:48:45 cxh Exp $
*/
public class PlotBoxMLParser extends HandlerBase {

    /** Construct an parser to parse commands for the specified plot object.
     *  @param plot The plot object to which to apply the commands.
     */
    public PlotBoxMLParser(PlotBox plot) {
        super();
        _plot = plot;
    }

    /** Protected constructor allows derived classes to set _plot
     *  differently.
     */
    protected PlotBoxMLParser() {}

    ///////////////////////////////////////////////////////////////////
    ////                         public methods                    ////

    /** Handle an attribute assignment that is part of an XML element.
     *  This method is called prior to the corresponding startElement()
     *  call, so it simply accumulates attributes in a hashtable for
     *  use by startElement().
     *  @param name The name of the attribute.
     *  @param value The value of the attribute, or null if the attribute
     *   is <code>#IMPLIED</code> and not specified.
     *  @param specified True if the value is specified, false if the
     *   value comes from the default value in the DTD rather than from
     *   the XML file.
     *  @exception XmlException If the name or value is null.
     */
    public void attribute(String name, String value, boolean specified)
            throws XmlException {
        if(name == null) throw new XmlException("Attribute has no name",
                _currentExternalEntity(),
                _parser.getLineNumber(),
                _parser.getColumnNumber());
        // NOTE: value may be null if attribute default is #IMPLIED.
        if (value != null) {
            _attributes.put(name, value);
        }
    }

    /** Handle character data.  In this implementation, the
     *  character data is accumulated in a buffer until the
     *  end element.
     *  &AElig;lfred will call this method once for each chunk of
     *  character data found in the contents of elements.  Note that
     *  the parser may break up a long sequence of characters into
     *  smaller chunks and call this method once for each chunk.
     *  @param chars The character data.
     *  @param offset The starting position in the array.
     *  @param length The number of characters available.
     */
    public void charData(char[] chars, int offset, int length) {
        _currentCharData.append(chars, offset, length);
    }

    /** End the document.  In this implementation, do nothing.
     *  &AElig;lfred will call this method once, when it has
     *  finished parsing the XML document.
     *  It is guaranteed that this will be the last method called.
     */
    public void endDocument() throws Exception {
    }

    /** End an element. For most elements this method
     *  calls the appropriate PlotBox method.
     *  &AElig;lfred will call this method at the end of each element
     *  (including EMPTY elements).
     *  @param elementName The element type name.
     */
    public void endElement(String elementName) throws Exception {
        if (elementName.equals("noGrid")) {
            _plot.setGrid(false);
        } else if (elementName.equals("noColor")) {
            _plot.setColor(false);
        } else if (elementName.equals("title")) {
            _plot.setTitle(_currentCharData.toString());
        } else if (elementName.equals("wrap")) {
            _plot.setWrap(true);
        } else if (elementName.equals("xLabel")) {
            _plot.setXLabel(_currentCharData.toString());
        } else if (elementName.equals("xLog")) {
            _plot.setXLog(true);
            // xRange and yRange are dealt with in startElement().
        } else if (elementName.equals("yLabel")) {
            _plot.setYLabel(_currentCharData.toString());
        } else if (elementName.equals("yLog")) {
            _plot.setYLog(true);
        }
    }

    /** Indicate a fatal XML parsing error.
     *  &AElig;lfred will call this method whenever it encounters
     *  a serious error.  This method simply throws an XmlException.
     *  @param message The error message.
     *  @param systemId The URI of the tntity that caused the error.
     *  @param line The approximate line number of the error.
     *  @param column The approximate column number of the error.
     *  @exception XmlException If called.
     */
    public void error(String message, String sysid,
            int line, int column) throws XmlException {
        throw new XmlException(message, _currentExternalEntity(), line, column);
    }

    /** Parse the given stream as a PlotML file.
     *  For example, an applet might use this method as follows:
     *  <pre>
     *     PlotBoxMLParser parser = new PlotBoxMLParser();
     *     URL docBase = getDocumentBase();
     *     URL xmlFile = new URL(docBase, modelURL);
     *     parser.parse(xmlFile.openStream());
     *  </pre>
     *  A variety of exceptions might be thrown if the parsed
     *  data does not represent a valid PlotML file.
     *  @param input The stream from which to read XML.
     *  @throws Exception If the parser fails.
     */
    public void parse(URL base, InputStream input) throws Exception {
        _parser.setHandler(this);
        if (base == null) {
            _parser.parse(null, null, input, null);
        } else {
            _parser.parse(base.toExternalForm(), null, input, null);
        }
    }

    /** Resolve an external entity.  This method returns null,
     *  which has the effect of deferring to &AElig;lfred for
     *  resolution of the URI.  Derived classes may return a
     *  a modified URI (a string), an InputStream, or a Reader.
     *  In the latter two cases, the input character stream is
     *  provided.
     *  @param publicId The public identifier, or null if none was supplied.
     *  @param systemId The system identifier.
     *  @return Null, indicating to use the default system identifier.
     */
    public Object resolveEntity(String publicID, String systemID) {
        return null;
    }

    /** Start a document.  This method is called just before the parser
     *  attempts to read the first entity (the root of the document).
     *  It is guaranteed that this will be the first method called.
     */
    public void startDocument() {
        _attributes = new Hashtable();
    }

    /** Start an element.
     *  This is called at the beginning of each XML
     *  element.  By the time it is called, all of the attributes
     *  for the element will already have been reported using the
     *  attribute() method.  Unrecognized elements are ignored.
     *  @param elementName The element type name.
     *  @exception XmlException If the element produces an error
     *   in constructing the model.
     */
    public void startElement(String elementName) throws XmlException {
        try {
            // NOTE: The elements are alphabetical below...
            if (elementName.equals("tick")) {
                String label = (String)_attributes.get("label");
                _checkForNull(label, "No label for element \"tick\"");

                String spec = (String)_attributes.get("position");
                _checkForNull(spec, "No position for element \"tick\"");
                // NOTE: Do not use parseDouble() to maintain Java 1.1
                // compatibility.
                double position = (Double.valueOf(spec)).doubleValue();

                if (_xtick) {
                    _plot.addXTick(label, position);
                } else {
                    _plot.addYTick(label, position);
                }

            } else if (elementName.equals("title")) {
                _currentCharData = new StringBuffer();

            } else if (elementName.equals("xLabel")) {
                _currentCharData = new StringBuffer();

            } else if (elementName.equals("xRange")) {
                String spec = (String)_attributes.get("min");
                _checkForNull(spec, "No min argument for element \"xRange\"");
                // NOTE: Do not use parseDouble() to maintain Java 1.1
                // compatibility.
                double min = (Double.valueOf(spec)).doubleValue();

                spec = (String)_attributes.get("max");
                _checkForNull(spec, "No max argument for element \"xRange\"");
                // NOTE: Do not use parseDouble() to maintain Java 1.1
                // compatibility.
                double max = (Double.valueOf(spec)).doubleValue();

                _plot.setXRange(min, max);

            } else if (elementName.equals("xTicks")) {
                _xtick = true;

            } else if (elementName.equals("yLabel")) {
                _currentCharData = new StringBuffer();

            } else if (elementName.equals("yRange")) {
                String spec = (String)_attributes.get("min");
                _checkForNull(spec, "No min argument for element \"yRange\"");
                // NOTE: Do not use parseDouble() to maintain Java 1.1
                // compatibility.
                double min = (Double.valueOf(spec)).doubleValue();

                spec = (String)_attributes.get("max");
                _checkForNull(spec, "No max argument for element \"yRange\"");
                // NOTE: Do not use parseDouble() to maintain Java 1.1
                // compatibility.
                double max = (Double.valueOf(spec)).doubleValue();

                _plot.setYRange(min, max);

            } else if (elementName.equals("yTicks")) {
                _xtick = false;
            }
        } catch (Exception ex) {
            if (ex instanceof XmlException) {
                throw (XmlException)ex;
            } else {
                String msg = "XML element \"" + elementName
                    + "\" triggers exception:\n  " + ex.toString();
                throw new XmlException(msg,
                        _currentExternalEntity(),
                        _parser.getLineNumber(),
                        _parser.getColumnNumber());
            }
        }
        _attributes.clear();
    }

    /** Handle the start of an external entity.  This pushes the stack so
     *  that error reporting correctly reports the external entity that
     *  causes the error.
     *  @param systemId The URI for the external entity.
     */
    public void startExternalEntity(String systemId) {
        _externalEntities.push(systemId);
    }

    ///////////////////////////////////////////////////////////////////
    ////                         protected methods                 ////

    /** If the argument is null, throw an exception with the given message.
     *  @param object The reference to check for null.
     *  @param message The message to issue if the reference is null.
     */
    protected void _checkForNull(Object object, String message)
            throws XmlException {
        if(object == null) {
            throw new XmlException(message,
                    _currentExternalEntity(),
                    _parser.getLineNumber(),
                    _parser.getColumnNumber());
        }
    }

    /** Get the the URI for the current external entity.
     *  @return A string giving the URI of the external entity being read,
     *   or null if none.
     */
    protected String _currentExternalEntity() {
        return (String)_externalEntities.peek();
    }

    ///////////////////////////////////////////////////////////////////
    ////                         protected members                 ////

    // NOTE: Do not use HashMap here to maintain Java 1.1 compatibility.
    /** Attributes associated with an entity. */
    protected Hashtable _attributes;

    /** The current character data for the current element. */
    protected StringBuffer _currentCharData;

    /** The parser. */
    protected XmlParser _parser = new XmlParser();

    /** The plot object to which to apply commands. */
    protected PlotBox _plot;

    ///////////////////////////////////////////////////////////////////
    ////                         private members                   ////

    // Indicator of whether we are parsing x ticks or y ticks.
    private boolean _xtick;

    // The external entities being parsed.
    private Stack _externalEntities = new Stack();
}
