#ifndef _ACSScheduler_h
#define _ACSScheduler_h

/*  Version @(#)ACSScheduler.h	1.6 09/08/99

@Copyright (c) 1998 The Regents of the University of California.
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

    Author:	T.M. Parks
    Created:	6 January 1992

*/

#ifdef __GNUG__
#pragma interface
#endif

#include "Scheduler.h"

class ACSScheduler : public Scheduler
{
public:
    // Constructor.
    ACSScheduler();

    // Domain identification.
    /*virtual*/ const char* domain() const;

    // Initialization.
    /*virtual*/ void setup();

    // Run (or continue) the simulation.
    /*virtual*/ int run();

    // Get the stopping time.
    /*virtual*/ double getStopTime();

    // Set the stopping time.
    /*virtual*/ void setStopTime(double);

    // Set the stopping time when inside a Wormhole.
    /*virtual*/ void resetStopTime(double);
};

#endif
