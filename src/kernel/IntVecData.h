#ifndef _IntVecData_h
#define _IntVecData_h 1
/**************************************************************************
Version identification:
@(#)IntVecData.h	2.11	3/2/95

Copyright (c) 1990-1995 The Regents of the University of California.
All rights reserved.

Permission is hereby granted, without written agreement and without
license or royalty fees, to use, copy, modify, and distribute this
software and its documentation for any purpose, provided that the
above copyright notice and the following two paragraphs appear in all
copies of this software.

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

Programmer:  J. T. Buck
Date of creation: 4/3/91

This is a simple vector packet body.  It stores an array of integer values
of arbitrary length.  The length is specified by the constructor.
**************************************************************************/
#ifdef __GNUG__
#pragma interface
#endif

#include "Message.h"

class IntVecData : public Message {
private:
	int len;

	void init(int l,const int *srcData);

public:
	// the pointer is public for simplicity
	int *data;

	int length() const { return len;}
	const char* dataType() const;
	int isA(const char*) const;

	// constructor: makes an uninitialized array
	IntVecData(int l);

	// constructor: makes an initialized array from a int array
	IntVecData(int l,int *srcData);

	// copy constructor
	IntVecData(const IntVecData& src);

	// clone
	Message* clone() const;

	// print
	StringList print() const;

	// destructor
	~IntVecData();
};
#endif
