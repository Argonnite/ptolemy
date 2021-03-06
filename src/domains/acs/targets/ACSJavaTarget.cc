static const char file_id[] = "ACSJavaTarget.cc";
/**********************************************************************
Copyright (c) 1998-2001 The Regents of the University of California.
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


 Programmers:  Eric Pauer (Sanders), Christopher Hylands, Edward A. Lee
 Date of creation: 1/15/98
 Version: @(#)ACSJavaTarget.cc	1.6 08/02/01

***********************************************************************/
#ifdef __GNUG__
#pragma implementation
#endif

#include "ACSJavaTarget.h"
#include "KnownTarget.h"

ACSJavaTarget::ACSJavaTarget(const char* name,const char* starclass,
        const char* desc, const char* assocDomain)
    : ACSCGTarget(name,starclass,desc,assocDomain) {}

ACSJavaTarget :: ~ACSJavaTarget() {}

Block* ACSJavaTarget::makeNew() const {
    LOG_NEW; return new ACSJavaTarget(name(),starType(),descriptor());
}

ISA_FUNC(ACSJavaTarget,ACSCGTarget);

static ACSJavaTarget targ("ACS-Java","ACSStar",
	"A target for Java code generation using Adaptive Computing System Coronas and Cores");

static KnownTarget entry(targ,"ACS-Java");
