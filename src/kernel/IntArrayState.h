#ifndef _IntArrayState_h
#define _IntArrayState_h 1

#ifdef __GNUG__
#pragma interface
#endif

#include "State.h"

/**************************************************************************
Version identification:
@(#)ArrayState.hP	2.8	02/02/94

Copyright (c) 1990-1994 The Regents of the University of California.
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
                                                        COPYRIGHTENDKEY


 Programmer:  I. Kuroda and J. T. Buck
 Date of creation: 6/8/90
 Revisions:

 State  with Int type

**************************************************************************/

///////////////////////////////////////////
// class  IntArrayState
///////////////////////////////////////////

class IntArrayState : public State
{
public:
	// Constructor
	IntArrayState () {nElements = 0; val = 0;}

	// Constructor
	IntArrayState (int size) { val = new int [nElements = size];}

	// Constructor, with fill value
	IntArrayState (int size, int& fill_value) ;

	// Destructor
	~IntArrayState () ;

	// Assignment operator
	IntArrayState &	operator = (const IntArrayState & v) ;

	// Size
	int size() const; // { return nElements;}

	// Array element 
	int & operator [] (int n) {
				return val[n];
			}

	// Cast to pointer to data
	operator int* () { return val; }

	// The type
	const char* type() const;

        // the value as a string
        StringList currentValue() const;

	// class identification
	int isA(const char*) const;
	const char* className() const;
	int isArray() const;

	// extend/truncate the array size
	void resize(int);

	// Parse initValue to set Value
	void initialize();

	// Parse element
	ParseToken evalExpression(Tokenizer&);

	// clone method
	State* clone() const; // {return new IntArrayState;}
protected:
	int	nElements;
	int	*val;
};

#endif
