# Makefile for Tycho tycho.edit.slate package
#
# @Author: Christopher Hylands
#
# @Version: @(#)makefile	1.47 09/27/98
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
VPATH =		$(ROOT)/edit/slate

# Get configuration info
CONFIG =	$(ROOT)/mk/tycho.mk
include $(CONFIG)

TYPACKAGE =     tycho.edit.slate
TYPACKAGE_ROOTDIR = $(ROOT)/edit/
TYPACKAGE_DIR = slate
# If you change JVERSION, modify the version numbers in slate.tcl
TYVERSION =     2.0
TYDIST =        $(TYPACKAGE)$(TYVERSION)
TYZIP =         $(TYPACKAGE_DIR)/$(TYPACKAGE).zip
TYJARFILE =

# Sub directories to run make in.
DIRS =		bin test doc demo compat

TCL_SRCS =
  
ITCL_SRCS = \
	Animator.itcl \
	Axis.itcl \
	Bounder.itcl \
	ComplexItem.itcl \
	DragDropper.itcl \
	Follower.itcl \
	Frame.itcl \
	Grapple.itcl \
	IconItem.itcl \
	IconFrame.itcl \
	IconOval.itcl \
	IconRect.itcl \
	Interactor.itcl \
	IncrCanvas.itcl \
	LabeledFrame.itcl \
	LabeledItem.itcl \
	LabeledLine.itcl \
	LabeledOval.itcl \
	LabeledRect.itcl \
	Line.itcl \
	TextItemEdit.itcl \
	Oval.itcl \
	Point.itcl \
	Polygon.itcl \
	Rectangle.itcl \
	Reshaper.itcl \
	Repeater.itcl \
	Selector.itcl \
	Shades.itcl \
	Shape.itcl \
	Slate.itcl \
	Slider.itcl \
	SmartLine.itcl \
	Solid.itcl \
	Stepper.itcl \
	Terminal.itcl

EXTRA_SRCS = $(TCL_SRCS) $(ITCL_SRCS) slate.tcl pkgIndex.tcl README.txt

MISC_FILES = $(DIRS) tclIndex bin demo img 

# 'make realclean' should remove tclIndex
REALCLEAN_STUFF =	tclIndex

# all install: $(MISC_SRCS) tclIndex

# We don't include common.mk since we don't use the compiler here
include $(ROOT)/mk/no-compile.mk
