# Makefile for Tycho tycho.edit.visedit package
#
# @Author: Christopher Hylands
#
# @Version: @(#)makefile	1.44 03/16/98
#
# @Copyright (c) 1996-1998 The Regents of the University of California.
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
ROOT =		../..

# True source directory
VPATH =		$(ROOT)/edit/visedit

# Get configuration info
CONFIG =	$(ROOT)/mk/tycho.mk
include $(CONFIG)

TCL_SRCS =
  
ITCL_SRCS = \
	DirectedAcyclicGraph.itcl \
	EditBubbleAndArc.itcl \
	EditDAG.itcl \
	EditForest.itcl \
	EditSTD.itcl \
	Forest.itcl \
	Graph.itcl \
	Graphics.itcl \
	HTMLExport.itcl

EXTRA_SRCS = $(TCL_SRCS) $(ITCL_SRCS) \
	graphics.style \
	pkgIndex.tcl \
	visedit.tcl

MISC_FILES = doc img test tclIndex 

# Sub directories to run make in.
DIRS =			doc test

# 'make realclean' should remove tclIndex
REALCLEAN_STUFF =	tclIndex

# Title for the tydoc index page
TYDOC_DESC =		Index of classes in tycho/edit/visedit

all install: $(MISC_SRCS) tclIndex 

# We don't include common.mk since we don't use the compiler here
include $(ROOT)/mk/no-compile.mk

