# Makefile for stubs for Ptolemy interface to Matlab, libptmatlab
# Version identification:
# @(#)make.template	1.6	07/25/97
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
# Date of creation: 11/6/95
#
# If this file's name is "make.template" and there is no makefile in
# this directory, do
#	cp make.template makefile
#	make depend
# This will add the dependencies to the makefile.

# Root of Ptolemy directory
ROOT=../../..
# Where we are
VPATH = ../../../src/utils/libptmatlab
# get configuration info
CONFIG=$(ROOT)/mk/config-$(PTARCH).mk
include $(CONFIG)

# Library name
# We only link against libptmatlab if matlab cannot be found at link time.
# See $PTOLEMY/mk/matlab.mk and $PTOLEMY/bin/matlabRootDir.
PTLIB =	libptmatlab.$(LIBSUFFIX)

# Put the Ptolemy kernel directory in the include path
INCL =	-I$(KERNDIR) $(PTCOMPAT_INCSPEC) $(MATLAB_INCSPEC) -I$(EXTTOOLSLIB)

# Library sources.  CCS_WITH_H_FILES includes all .cc files with a
# corresponding .h file with the same root.
CCS_WITH_H_FILES = MatlabHook.cc

# The complete list of .cc files used in the library
SRCS = $(CCS_WITH_H_FILES)

# Header files.  When adding a new header, add it here only if there is
# no corresponding .cc file; otherwise add the .cc file to CCS_WITH_H_FILES.
HDRS= $(CCS_WITH_H_FILES:.cc=.h)

# Library objects
OBJS=$(SRCS:.cc=.o) $(MATLABEXT2_LIB)

all:	makefile $(PTLIB)

# "make install" puts things in the official place
install:	makefile $(LIBDIR)/$(PTLIB)

# matlab.mk and mathematica.mk check these vars before traversing the path
NEED_MATLABDIR = 	1
NEED_MATHEMATICADIR = 	1

# Include common make definitions
include $(ROOT)/mk/common.mk

# Don't add anything after the next line; makedepend will zap it.
# DO NOT DELETE THIS LINE -- make depend depends on it.

MatlabHook.o: MatlabHook.cc MatlabHook.h \
 ../../../src/utils/libexttools/MatlabIfcFuns.h \
 ../../../src/compat/ptolemy/compat.h \
 ../../../src/utils/libexttools/MatlabIfc.h \
 ../../../src/kernel/StringList.h ../../../src/kernel/miscFuncs.h \
 ../../../src/kernel/logNew.h ../../../src/kernel/Error.h \
 ../../../src/kernel/DataStruct.h ../../../src/kernel/type.h \
 ../../../src/kernel/InfString.h \
 ../../../src/utils/libexttools/MatlabIfc.h.Auto \
 ../../../src/utils/libexttools/MatlabHook.cc.Auto
