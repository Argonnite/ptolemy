# Ptolemy Makefile for Rosetta Man, use by tkman
# Version identification:
# @(#)make.template	1.10 04/15/98
# Copyright (c) 1990-1998 The Regents of the University of California.
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
RMAN_VERSION = 2.5a6
ROOT = ../../..
VPATH = $(ROOT)/src/utils/rman-$(RMAN_VERSION)
BINDIR = $(ROOT)/bin.$(PTARCH)

# get configuration info
CONFIG=$(ROOT)/mk/config-$(PTARCH).mk
include $(CONFIG)

SRCS = 	rman.c

KRUFT =

# common.mk wants this, otherwise we get multiple targets for $(LIBDIR)/$(PTLIB)
PTLIB = foo

KRUFT = rman

MISC_FILES =	Copyright MANIFEST Makefile.dist README-rman contrib \
		rman.1 rman.html Makefile.mac getopt.c macish.c

# Special to rman
VOLLIST = "1:2:3:4:5:6:7:8:9:o:l:n:p"
MANTITLEPRINTF = "%s(%s) manual page"
MANREFPRINTF = "http://localhost/cgi-bin/man2html?%s?%s"
C_INCL =	$(PTCOMPAT_INCSPEC) \
	-DVOLLIST='$(VOLLIST)' -DMANTITLEPRINTF='$(MANTITLEPRINTF)' \
	-DMANREFPRINTF='$(MANREFPRINTF)' \
	-DROSETTAMANVERSION=\"2.5\"

# include common definitions, rules
include $(ROOT)/mk/common.mk

BINARY = rman$(BINARY_EXT)
all:	makefile $(BINARY)

install:	$(BINARY) $(BINDIR)/$(BINARY) $(ROOT)/man/man1/rman.1

$(BINARY):	rman.o
	rm -f $@
	$(CC) $^ -o $(BINARY)

$(BINDIR)/$(BINARY):	$(BINARY)
	@echo Installing $<
	rm -f $@
	ln $< $@

$(ROOT)/man/man1/rman.1: rman.1
	# Can't use mkdir -p here, because not all machines have it
	-if [ ! -d $(ROOT)/man ]; then mkdir $(ROOT)/man; fi
	-if [ ! -d $(ROOT)/man/man1 ]; then mkdir $(ROOT)/man/man1; fi
	@echo Installing $<
	rm -f $@
	cp $< $@

# Don't add anything after the next line; makedepend will zap it.
# DO NOT DELETE THIS LINE -- make depend depends on it.


rman.o: rman.c
