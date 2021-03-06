# Makefile for Ptolemy Tycho system, editors/slate/test directory.
#
# @(#)makefile	1.32 07/29/98
# Makefile Author: Christopher Hylands
#
# Copyright (c) 1996-1998 The Regents of the University of California.
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


# Root of Ptolemy directory
ROOT =		../../..

# True source directory
VPATH =		$(ROOT)/tycho/editors/slate

# get configuration info
CONFIG =	$(ROOT)/mk/tycho.mk
include $(CONFIG)

TCL_SRCS = \
	defs2.tcl
  
ITCL_SRCS = \
	$(GRAPHICAL_TESTS) \
	defs.itcl

EXTRA_SRCS =	$(TCL_SRCS) $(ITCL_SRCS)

MISC_FILES = \
	makefile \
	test \
	test.tcl \
	pkgIndex.tcl

# If we get some SIMPLE_TESTS, then add $(SIMPLE_TESTS)
# to ITCL_SRCS above.
# SIMPLE_TESTS cannot be empty, or the script that builds alltests.itcl
# and all.itcl will barf.
SIMPLE_TESTS = \
	dummy.tcl

# Test in the order in which they are to be executed
GRAPHICAL_TESTS = \
	testIncrCanvas.itcl \
	testSlate.itcl \
	testShape.itcl \
	testPolygon.itcl \
	testRectangle.itcl \
	testLine.itcl \
	testFrame.itcl \
	testLabeledItem.itcl \
	testLabeledRect.itcl \
	testLabeledFrame.itcl \
	testIconItem.itcl \
	testIconRect.itcl \
	testIconFrame.itcl \
	testInteractor.itcl \
	testFollower.itcl \
	testBounder.itcl 


# Scripts that are generated
TEST_SCRIPTS =  alltests.itcl all.itcl

# make checkjunk should not complain about the OLD directory
OPTIONAL_FILES = $(TEST_SCRIPTS)

# 'make realclean' should remove tclIndex
REALCLEAN_STUFF = $(TEST_SCRIPTS)

tests:: test_graphics

# These tests do not require a graphics terminal
test_simple: $(TCL_SRCS) $(ITCL_SRCS) $(TEST_SCRIPTS)

	tytestsh $(SIMPLE_TESTS)

# These tests require a graphics terminal
test_graphics: alltests.itcl all.itcl $(TCL_SRCS) $(ITCL_SRCS) $(TEST_SCRIPTS)
	tytest $(GRAPHICAL_TESTS)


# We don't include common.mk since we don't use the compiler here
include $(ROOT)/mk/no-compile.mk

