# Makefile for the Tycho tycho.kernel.gui package, demos/ directory
#
# @Author: Christopher Hylands
#
# @Version: @(#)makefile	1.3 06/09/98
#
# @Copyright (c) 1998 The Regents of the University of California.
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
VPATH =		$(ROOT)/kernel/gui/demos

# Get configuration info
CONFIG =	$(ROOT)/mk/tycho.mk
include $(CONFIG)

# Sub directories to run make in.
DIRS =	

TCL_SRCS = 

ITCL_SRCS = 

EXTRA_SRCS = $(TCL_SRCS) $(ITCL_SRCS) widgettree labeledgrid

MISC_FILES = 

# 'make realclean' should remove tclIndex
REALCLEAN_STUFF =

# Title for the tydoc index page
TYDOC_DESC =

# Do make sources so that we ensure that the subdirectories are checked out
all install: sources $(MISC_SRCS)
	chmod a+x widgettree
	chmod a+x labeledgrid

# We have an all rule, so include tycommon.mk.
include $(ROOT)/mk/tycommon.mk
