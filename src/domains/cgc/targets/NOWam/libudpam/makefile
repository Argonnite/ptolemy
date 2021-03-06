# Makefile for CGC NOW (Networks Of Workstations) udp library
# Version identification:
# @(#)make.template	1.10 7/23/96
# Copyright (c) 1990-1996 The Regents of the University of California.
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
# Date of creation: 1/30/96
#
# If this file's name is "make.template" and there is no makefile in
# this directory, do
#	cp make.template makefile
#	make depend
# This will add the dependencies to the makefile.

# Root of Ptolemy directory
ROOT =	../../../../../..
# True source directory
VPATH = $(ROOT)/src/domains/cgc/targets/NOWam/libudpam

# get configuration info
CONFIG =$(ROOT)/mk/config-$(PTARCH).mk
include $(CONFIG)

SRCS = 	management.c misc.c transport.c

HDRS =	am.h misc.h udpam.h transport.h

OBJS = 	$(SRCS:.c=.o)

LIBNONSHARED = libudpam.a

MISC_FILES = Makefile.dist

# This probably only works under Solaris
#OS =	AIX
OS =	SOLARIS

# Give me those printfs!
DEBUG = -DDEBUG 

# GNU make extension, add our stuff to CFLAGS
CFLAGS += -D$(OS) $(DEBUG)

C_INCL = -I$(VPATH) $(PTCOMPAT_INCSPEC)

# include common definitions, rules
include $(ROOT)/mk/common.mk


# sol2 and sol2.cfront
ifneq (,$(filter sol%,$(PTARCH)))
all: makefile $(SRCS) $(LIBNONSHARED)

install: makefile $(SRCS) $(LIBDIR)/$(LIBNONSHARED)
else
# Non solaris platforms
all: makefile
	@echo "NOW active message library not supported on non-Solaris platforms"
install: makefile
	@echo "NOW active message library not supported on non-Solaris platforms"
endif

lint:	$(LIBCSRCS)
	lint -u $(INCL) $(LIBCSRCS) > lint

# Don't add anything after the next line; makedepend will zap it.

management.o: management.c
misc.o: misc.c
transport.o: transport.c
