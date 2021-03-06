# Makefile for the Tycho tycho.util.idoc package
#
# @Authors: Christopher Hylands, John Reekie
#
# @Version: @(#)makefile	1.4 08/25/98
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
ROOT =		../..

# True source directory
VPATH =		$(ROOT)/util/idoc

# Get configuration info
CONFIG =	$(ROOT)/mk/tycho.mk
include $(CONFIG)

# The variables below are used to create distributions
TYPACKAGE = 	tycho.util.idoc
TYPACKAGE_ROOTDIR = $(ROOT)/tycho
TYPACKAGE_DIR = tycho/util/idoc
# If you change JVERSION, modify the version numbers in idoc.tcl
TYVERSION =	1.0
TYDIST =	$(TYPACKAGE)$(TYVERSION)
TYZIP =		$(TYPACKAGE_DIR)/$(TYPACKAGE).zip
TYJARFILE =

# Sub directories to run make in.
DIRS =	bin demo doc test

TCL_SRCS =

ITCL_SRCS =  \
	ClassModel.itcl \
	ClassParser.itcl \
	ClassViewer.itcl \
	ItclParser.itcl \
	ItclViewer.itcl \
	JavaParser.itcl \
	JavaViewer.itcl \
	MultiPanel.itcl

EXTRA_SRCS = $(TCL_SRCS) $(ITCL_SRCS) \
	idoc.tcl \
	README.txt \
	idoc.style \
	pkgIndex.tcl

MISC_FILES = $(DIRS) tclIndex

# make checkjunk will not report OPTIONAL_FILES as trash
OPTIONAL_FILES =	adm

# 'make realclean' should remove tclIndex
REALCLEAN_STUFF = tclIndex

# Title for the tydoc index page
TYDOC_DESC =

# Do make sources so that we ensure that the subdirectories are checked out
all: sources $(MISC_SRCS) tclIndex

install: all

.PHONY: all

# We don't include common.mk since we don't use the compiler here
include $(ROOT)/mk/no-compile.mk


