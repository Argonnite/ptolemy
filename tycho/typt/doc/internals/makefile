# Makefile for Ptolemy Tycho system, typt/doc/internals directory.
#
# @(#)makefile	1.5 09/17/97
# Author: Christopher Hylands
#
# Copyright (c) 1996-1997 The Regents of the University of California.
# All rights reserved.
# 
# Permission is hereby granted, without written agreement and without
# license or royalty fees, to use, copy, modify, and distribute this
# software and its documentation for any purpose, provided that the
# above copyright notice and the following two paragraphs appear in all
# copies of this software.
# 
# IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY
# FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES
# ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
# THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
# SUCH DAMAGE.
# 
# THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY WARRANTIES,
# INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
# MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
# PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
# CALIFORNIA HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES,
# ENHANCEMENTS, OR MODIFICATIONS.
# 
# 						PT_COPYRIGHT_VERSION_2
# 						COPYRIGHTENDKEY
##########################################################################

# Root of Tycho directory
ROOT =		../../..

# True source directory
VPATH =		$(ROOT)/typt/doc/internals

# Get configuration info
CONFIG =	$(ROOT)/mk/tycho.mk
include $(CONFIG)

EXTRA_SRCS =	\
	index.html \
	pitclStart.html \
	pitcl.html

MISC_FILES = 

# 'make realclean' should remove tclIndex
REALCLEAN_STUFF =

# Sub directories to run make in.
DIRS =

# We don't include common.mk since we don't use the compiler here
include $(ROOT)/mk/no-compile.mk

# pitcl.html is automagically generated from the PITcl.cc sources
# by a script in $PTOLEMY/src/pitcl.
pitcl.html:
	@if [ -d $(PTOLEMY)/src/pitcl ]; then \
		(cd $(PTOLEMY)/src/pitcl; make updatetychodocs); \
	else \
		echo "$(PTOLEMY)/src/pitcl does not exist, so we can't create pitcl.html"; \
	fi

