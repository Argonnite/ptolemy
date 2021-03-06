# Makefile for Ptolemy Tycho system, tycho/doc directory.
#
# @(#)makefile	1.61	01/11/99
# Author: Christopher Hylands
#
# Copyright (c) 1991-1998 The Regents of the University of California.
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
ROOT =		..

# True source directory
VPATH =		$(ROOT)/doc

# Get configuration info
CONFIG =	$(ROOT)/mk/tycho.mk
include $(CONFIG)

# Sub directories to run make in.
DIRS =		coding packages #demo

EXTRA_SRCS =	\
		abbreviations.html \
		authors.html \
		bindings.html \
		brahe.html \
		bugs0.1.html \
		bugs.html \
		documentation.html \
		help.html \
		index.html \
		install.html \
		introduction.html \
		itcllinks.html \
		overview.html \
		policies.html \
		rationale.html \
		releasenotes.html \
		releasenotes0.1.html \
		releasenotes0.1.1.html \
		releasenotes0.2.html \
		releasenotes0.2.1.html \
		releasenotes0.3.html \
		running.html \
		sponsors.html \
		troubleshooting.html \
		tychoClasses.html \
		tychoFaq.html \
		tynt.html \
		tyunix.html


# Files or directories that are present, but that 'make checkjunk' 
# should not complain about
MISC_FILES =		$(DIRS) img itclhtml tychoClasses.dag 

# make checkjunk will not report OPTIONAL_FILES as trash
# make realclean removes OPTIONAL_FILES
OPTIONAL_FILES = 	

# 'make realclean' should remove tclIndex
REALCLEAN_STUFF =	tychoClasses.dag

all: sources tychoClasses.dag

FORCE:

tychoClasses.dag: FORCE
	@echo "Generating diagram of tycho classes"
	rm -f $@
	@if [ "$(TYCHO)" = "" ]; then \
		echo "TYCHO is not set so we assume we are part of PTOLEMY"; \
		echo "Running $(ITCLSH), \$$PTOLEMY=$(PTOLEMY)"; \
		echo "set TYCHO \"$(PTOLEMY)/tycho\"; source ../kernel/basic/tychoMakeClassDAG.tcl; tychoStandardDAG" | $(ITCLSH); \
	else \
		echo "Running $(ITCLSH)"; \
		echo "set TYCHO \"$(TYCHO)\"; source ../kernel/basic/tychoMakeClassDAG.tcl; tychoStandardDAG" | $(ITCLSH); \
	fi

HTMLDIRS= $(TYCHO)/doc \
	$(TYCHO)/doc/coding \
	$(TYCHO)/util/tydoc/doc \
	$(TYCHO)/doc/packages \
	$(TYCHO)/kernel/basic/doc/usersGuides \
	$(TYCHO)/kernel/model/doc/usersGuides \
	$(TYCHO)/kernel/gui/doc/usersGuides \
	$(TYCHO)/kernel/html/doc/usersGuides \
	$(TYCHO)/edit/textedit/doc/usersGuides \
	$(TYCHO)/edit/visedit/doc/usersGuides \
	$(TYCHO)/edit/graphedit/doc/usersGuides \
	$(TYCHO)/edit/slate/doc/usersGuides \
	$(TYCHO)/util/devtools/doc/usersGuides \
	$(TYCHO)/util/tydoc/doc/usersGuides \
	$(TYCHO)/util/notmake/doc/usersGuides \
	$(TYCHO)/util/pakman/doc/usersGuides \
	$(TYCHO)/util/tytest/doc/usersGuides \
	$(TYCHO)/kernel/basic/doc/internals \
	$(TYCHO)/kernel/gui/doc/internals \
	$(TYCHO)/edit/slate/doc/internals \
	$(TYCHO)/src/tytest \
	$(TYCHO)/src/tytimer \
	$(TYCHO)/typt/doc \
	$(TYCHO)/typt/doc/internals \
	$(TYCHO)/typt/doc/usersGuides \
	$(TYCHO)/typt/edit/doc/usersGuides

# Traverse all the html files (except the codedoc files) and produce PostScript
tycho.ps: ../bin/html2ps
	echo "You must be running netscape"
	-chmod a+x $^
	../bin/html2ps -d index.html tycho.ps $(HTMLDIRS)

# We don't include common.mk since we don't use the compiler here
include $(ROOT)/mk/no-compile.mk
