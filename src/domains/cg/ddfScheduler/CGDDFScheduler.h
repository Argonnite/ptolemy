/******************************************************************
Version identification:
@(#)CGDDFScheduler.h	1.2	1/1/96

Copyright (c) 1995 Seoul National University
Copyright (c) 1990-1996 The Regents of the University of California.
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

 Programmer:  Soonhoi Ha

 macroScheduler for efficient and flexible parallel scheduler

*******************************************************************/

#ifndef _CGDDFScheduler_h
#define _CGDDFScheduler_h
#ifdef __GNUG__
#pragma interface
#endif

#include "MacroScheduler.h"

/////////////////////////
// class CGDDFScheduler //
/////////////////////////

class CGDDFScheduler : public MacroScheduler {

public:
	CGDDFScheduler(MultiTarget* t, const char* log = 0) : 
		MacroScheduler(t,log) {}

protected:
	/* virtual */ CGMacroClusterGal* createClusterGal(Galaxy*, ostream*);

};


#endif
