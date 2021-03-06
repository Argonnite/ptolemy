// XmlApp.java: base class for �lfred demos.
// NO WARRANTY! See README, and copyright below.
// $Id: XmlApp.java,v 1.2 1998/11/08 13:55:18 neuendor Exp $
// Modified 11/8/98 to add package statement.

package com.microstar.xml.demo;

import com.microstar.xml.XmlHandler;
import com.microstar.xml.XmlParser;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.io.InputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;


/**
  * Base class for &AElig;lfred demonstration applications.
  * <p>This class fills in the basic interface, and provides
  * an I/O infrastructure for simple applications and applets.
  * @author Copyright (c) 1997, 1998 by Microstar Software Ltd.;
  * @author written by David Megginson &lt;dmeggins@microstar.com&gt;
  * @version 1.1
  * @see com.microstar.xml.XmlParser
  * @see com.microstar.xml.XmlHandler
  * @see EventDemo
  * @see TimerDemo
  * @see DtdDemo
  * @see StreamDemo
  */
public class XmlApp implements XmlHandler {


  /**
    * Flag to show whether we're running as an applet or application.
    */
  public boolean isApplet = false;

  public XmlParser parser;



  //////////////////////////////////////////////////////////////////////
  // Implementation of XmlParser interface.
  //
  // The following methods provide a full skeleton implementation of the
  // XmlHandler interface, so that subclasses can override only
  // the methods they need.
  //////////////////////////////////////////////////////////////////////


  /**
    * Resolve an external entity.
    * <p>This method could generate a new URL by looking up the
    * public identifier in a hash table, or it could replace the
    * URL supplied with a different, local one; for now, however,
    * just return the URL supplied.
    * @see com.Microstar.xml.XmlHandler#resolveEntity
    */
  public Object resolveEntity (String publicId, String systemId)
  {
    return null;
  }


  public void startExternalEntity (String systemId)
  {
  }


  public void endExternalEntity (String systemId)
  {
  }


  /**
    * Handle the start of the document.
    * <p>Do nothing for now.  Subclasses can override this method
    * if they want to take a specific action.
    * <p>This method will always be called first.
    * @see com.Microstar.xml.XmlHandler#startDocument
    */
  public void startDocument ()
  {
  }


  /**
    * Handle the end the document.
    * <p>Do nothing for now.  Subclasses can override this method
    * if they want to take a specific action.
    * <p>This method will always be called last.
    * @see com.Microstar.xml.XmlHandler#endDocument
    */
  public void endDocument ()
  {
  }


  /**
    * Handle a DOCTYPE declaration.
    * <p>Do nothing for now.  Subclasses can override this method
    * if they want to take a specific action.
    * <p>Well-formed XML documents might not have one of these.
    * <p>The query methods in XmlParser will return useful
    * values only after this callback.
    * @see com.Microstar.xml.XmlHandler#doctypeDecl
    */
  public void doctypeDecl (String name,
			   String pubid, String sysid)
  {
  }


  /**
    * Handle an attribute value specification.
    * <p>Do nothing for now.  Subclasses can override this method
    * if they want to take a specific action.
    * @see com.Microstar.xml.XmlHandler#attribute
    */
  public void attribute (String name, String value,
			 boolean isSpecified)
  {
  }


  /**
    * Handle the start of an element.
    * <p>Do nothing for now.  Subclasses can override this method
    * if they want to take a specific action.
    * @see com.Microstar.xml.XmlHandler#startElement
    */
  public void startElement (String name)
  {
  }


  /** 
    * Handle the end of an element.
    * <p>Do nothing for now.  Subclasses can override this method
    * if they want to take a specific action.
    * @see com.Microstar.xml.XmlHandler#endElement
    */
  public void endElement (String name)
  {
  }


  /**
    * Handle character data.
    * <p>Do nothing for now.  Subclasses can override this method
    * if they want to take a specific action.
    * @see com.Microstar.xml.XmlHandler#charData
    */
  public void charData (char ch[], int start, int length)
  {
  }


  /**
    * Handle ignorable whitespace.
    * <p>Do nothing for now.  Subclasses can override this method
    * if they want to take a specific action.
    * @see com.Microstar.xml.XmlHandler#ignorableWhitespace
    */
  public void ignorableWhitespace (char ch[], 
				   int start, int length)
  {
  }


  /**
    * Handle a processing instruction.
    * <p>Do nothing for now.  Subclasses can override this method
    * if they want to take a specific action.
    * @see com.Microstar.xml.XmlHandler#processingInstruction
    */
  public void processingInstruction (String target,
				     String data)
  {
  }


  /**
    * Handle a parsing error.
    * <p>By default, print a message and throw an Error.
    * <p>Subclasses can override this method if they want to do something
    * different.
    * @see com.Microstar.xml.XmlHandler#error
    */
  public void error (String message,
		     String url, int line, int column)
  {
    displayText("FATAL ERROR: " + message);
    displayText("  at " + url.toString() + ": line " + line
		+ " column " + column);
    throw new Error(message);
  }



  //////////////////////////////////////////////////////////////////////
  // General utility methods.
  //////////////////////////////////////////////////////////////////////



  /**
    * Start a parse in application mode.
    * <p>Output will go to STDOUT.
    * @see #displayText
    * @see com.microstar.xml.XmlParser#run
    */
  void doParse (String url)
    throws java.lang.Exception
  {
    String docURL = makeAbsoluteURL(url);

				// create the parser
    parser = new XmlParser();
    parser.setHandler(this);
    parser.parse(makeAbsoluteURL(url), null, (String)null);
  }

  static String makeAbsoluteURL (String url)
    throws MalformedURLException
  {
    URL baseURL;

    String currentDirectory = System.getProperty("user.dir");

    String fileSep = System.getProperty("file.separator");
    String file = currentDirectory.replace(fileSep.charAt(0), '/') + '/';
    if (file.charAt(0) != '/') {
      file = "/" + file;
    }
    baseURL = new URL("file", null, file);
    return new URL(baseURL,url).toString();
  }


  /**
    * Display text on STDOUT or in an applet TextArea.
    */
  void displayText (String text)
  {
    System.out.println(text);
  }


  /**
    * Escape a string for printing.
    */
  String escape (char ch[], int length)
  {
    StringBuffer out = new StringBuffer();
    for (int i = 0; i < length; i++) {
      switch (ch[i]) {
      case '\\':
	out.append("\\\\");
	break;
      case '\n':
	out.append("\\n");
	break;
      case '\t':
	out.append("\\t");
	break;
      case '\r':
	out.append("\\r");
	break;
      case '\f':
	out.append("\\f");
	break;
      default:
	out.append(ch[i]);
	break;
      }
    }
    return out.toString();
  }

}

// end of XmlApp.java
