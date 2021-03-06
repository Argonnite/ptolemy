# Makefile for Ptolemy/Tcl interpreter
# Version identification:
# @(#)make.template	1.66 02/20/99
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
# Date of creation: 3/4/92
# Authors: J. Buck, Christopher Hylands, Jose Luis Pino
#
# If this file's name is "make.template" and there is no makefile in
# this directory, do
#	cp make.template makefile
#	make depend
# This will add the dependencies to the makefile.

# Root of Ptolemy directory
ROOT =		../..
# Path (absolute or relative) to the object directory root
OBJDIR =	..
# True source directory
VPATH =		$(ROOT)/src/ptcl

# get configuration info
CONFIG =	$(ROOT)/mk/config-$(PTARCH).mk
include $(CONFIG)

# if you want to create a custom pigiRpc, define a override.mk
# file that defines the necessary variables to pull in the domains
# you want.  See $(ROOT)/mk/ptbin.mk.  This files must at least 
# define the variable PTCL which defines the name of the ptcl executable.

-include override.mk

ifndef BASENAME
ifndef PIGI
	ALLBINARIES = 1
	BASENAME = ptcl
	PIGI = ptcl
endif
endif

# $PTOLEMY/mk/ptbin.mk checks $(PTCL)
PTCL = 1

INCL = 		-I$(KERNDIR) -I$(ITCL_INCDIR) -I$(TCL_INCDIR) \
		$(PTCOMPAT_INCSPEC) $(MATLAB_INCSPEC) $(MATLABIFC_INCSPEC) \
		$(MATHEMATICA_INCSPEC) $(MATHEMATICAIFC_INCSPEC)

C_INCL =	$(PTCOMPAT_INCSPEC) -I$(TCL_INCDIR) -I$(TK_INCDIR)

# Sources: LIB_SRCS contains the files that make up libptcl.so.
# NON_LIB_SRCS contains the files that do not go into libptcl.so.
LIB_SRCS =	MatlabTcl.cc MathematicaTcl.cc PTcl.cc ptclInit.cc \
		ptclError.cc ptclGantt.cc \
		ptclDescription.cc
LIB_CSRCS = 	displayFile.c
NON_LIB_SRCS =	ptclAppInit.cc
SRCS =		$(LIB_SRCS) $(LIB_CSRCS) $(NON_LIB_SRCS) ptclInvokeInterp.cc

# Header files
HDRS =		displayFile.h \
		MatlabTcl.h MathematicaTcl.h PTcl.h ganttChart.h \
		ptclDescription.h

# Objects that make up the library
OBJS =		$(LIB_SRCS:.cc=.o) $(LIB_CSRCS:.c=.o)

# Used to create .dlls under nt4.vc
DLLDEPS = ..\utils\libexttools\libexttools.lib \
	..\kernel\libptolemy.lib \
	$(TCL_LIBDEP)

# HPUX has a hard time handling symbols that are defined both in a static
# library and in a shared library, so, since we have different Error::
# functions for pigiRpc, ptcl and tycho, we need to be sure that
# libpigi, libptcl and libtycho are all static on the hppa.
ifdef USE_CORE_STATIC_LIBS
LIBNONSHARED =	libptcl.a
INSTALL =	$(LIBDIR)/$(LIBNONSHARED)
else
PTLIB =		libptcl.$(LIBSUFFIX)
INSTALL =	$(LIBDIR)/$(PTLIB)
endif

PT_DEPEND += $(NON_LIB_SRCS:.cc=.o) ptclInvokeInterp.o

PIGI_OBJS += $(NON_LIB_SRCS:.cc=.o) 


# ptbin.mk has the default rule that creates a binary and the all: rule
include $(ROOT)/mk/ptbin.mk

all: $(PIGI) $(PIGI).ptiny $(PIGI).ptrim

# include common definitions, rules
include $(ROOT)/mk/common.mk


# Don't add anything after the next line; makedepend will zap it.
# DO NOT DELETE THIS LINE -- make depend depends on it.
MatlabTcl.o: MatlabTcl.cc ../../src/kernel/miscFuncs.h \
 ../../src/kernel/logNew.h ../../src/kernel/Error.h \
 ../../src/kernel/StringList.h ../../src/kernel/DataStruct.h \
 ../../src/kernel/type.h ../../src/utils/libexttools/MatlabIfcFuns.h \
 ../../src/compat/ptolemy/compat.h \
 ../../src/utils/libexttools/MatlabIfc.h ../../src/kernel/InfString.h \
 ../../src/utils/libexttools/MatlabIfc.h.Auto MatlabTcl.h \
 ../../src/utils/libexttools/InstanceManager.h
MathematicaTcl.o: MathematicaTcl.cc ../../src/kernel/miscFuncs.h \
 ../../src/kernel/logNew.h ../../src/kernel/Error.h \
 ../../src/kernel/StringList.h ../../src/kernel/DataStruct.h \
 ../../src/kernel/type.h ../../src/kernel/InfString.h \
 ../../src/utils/libexttools/MathematicaIfc.h \
 ../../src/utils/libptmathematica/MathematicaIfcFuns.h \
 ../../src/compat/ptolemy/compat.h MathematicaTcl.h \
 ../../src/utils/libexttools/InstanceManager.h
PTcl.o: PTcl.cc ../../src/kernel/isa.h PTcl.h \
 ../../src/kernel/NamedObj.h ../../src/kernel/StringList.h \
 ../../src/kernel/miscFuncs.h ../../src/kernel/logNew.h \
 ../../src/kernel/Error.h ../../src/kernel/DataStruct.h \
 ../../src/kernel/type.h ../../src/kernel/FlagArray.h \
 ../../src/kernel/SimControl.h ../../src/kernel/InterpUniverse.h \
 ../../src/kernel/Universe.h ../../src/kernel/Galaxy.h \
 ../../src/kernel/Star.h ../../src/kernel/Block.h \
 ../../src/kernel/PortHole.h ../../src/kernel/dataType.h \
 ../../src/kernel/Particle.h ../../src/kernel/Fix.h \
 ../../src/kernel/ComplexSubset.h ../../src/kernel/Attribute.h \
 ../../src/kernel/State.h ../../src/kernel/InvokeInterp.h \
 ../../src/kernel/Target.h ../../src/kernel/InterpGalaxy.h \
 ../../src/kernel/DynamicGalaxy.h ../../src/kernel/KnownBlock.h \
 ../../src/kernel/Linker.h ../../src/kernel/KnownTarget.h \
 ../../src/kernel/Domain.h ../../src/kernel/textAnimate.h \
 ../../src/kernel/ConstIters.h ../../src/kernel/Scheduler.h \
 ../../src/kernel/InfString.h ptclDescription.h MatlabTcl.h \
 ../../src/utils/libexttools/MatlabIfc.h \
 ../../src/utils/libexttools/MatlabIfcFuns.h \
 ../../src/compat/ptolemy/compat.h \
 ../../src/utils/libexttools/MatlabIfc.h.Auto \
 ../../src/utils/libexttools/InstanceManager.h MathematicaTcl.h \
 ../../src/utils/libexttools/MathematicaIfc.h \
 ../../src/utils/libptmathematica/MathematicaIfcFuns.h
ptclInit.o: ptclInit.cc ../../src/compat/ptolemy/compat.h PTcl.h \
 ../../src/kernel/NamedObj.h ../../src/kernel/StringList.h \
 ../../src/kernel/miscFuncs.h ../../src/kernel/logNew.h \
 ../../src/kernel/Error.h ../../src/kernel/DataStruct.h \
 ../../src/kernel/type.h ../../src/kernel/isa.h \
 ../../src/kernel/FlagArray.h ../../src/kernel/SimControl.h
ptclError.o: ptclError.cc PTcl.h ../../src/kernel/NamedObj.h \
 ../../src/kernel/StringList.h ../../src/kernel/miscFuncs.h \
 ../../src/kernel/logNew.h ../../src/kernel/Error.h \
 ../../src/kernel/DataStruct.h ../../src/kernel/type.h \
 ../../src/kernel/isa.h ../../src/kernel/FlagArray.h \
 ../../src/kernel/SimControl.h
ptclGantt.o: ptclGantt.cc PTcl.h ../../src/kernel/NamedObj.h \
 ../../src/kernel/StringList.h ../../src/kernel/miscFuncs.h \
 ../../src/kernel/logNew.h ../../src/kernel/Error.h \
 ../../src/kernel/DataStruct.h ../../src/kernel/type.h \
 ../../src/kernel/isa.h ../../src/kernel/FlagArray.h \
 ../../src/kernel/SimControl.h ganttChart.h
ptclDescription.o: ptclDescription.cc ../../src/kernel/PortHole.h \
 ../../src/kernel/NamedObj.h ../../src/kernel/StringList.h \
 ../../src/kernel/miscFuncs.h ../../src/kernel/logNew.h \
 ../../src/kernel/Error.h ../../src/kernel/DataStruct.h \
 ../../src/kernel/type.h ../../src/kernel/isa.h \
 ../../src/kernel/FlagArray.h ../../src/kernel/dataType.h \
 ../../src/kernel/Particle.h ../../src/kernel/Fix.h \
 ../../src/kernel/ComplexSubset.h ../../src/kernel/Attribute.h \
 ../../src/kernel/Star.h ../../src/kernel/Block.h \
 ../../src/kernel/State.h ../../src/kernel/InvokeInterp.h \
 ../../src/kernel/Galaxy.h ../../src/kernel/GalIter.h \
 ../../src/kernel/pt_fstream.h
displayFile.o: displayFile.c displayFile.h
ptclAppInit.o: ptclAppInit.cc ../../src/kernel/Linker.h
ptclInvokeInterp.o: ptclInvokeInterp.cc PTcl.h \
 ../../src/kernel/NamedObj.h ../../src/kernel/StringList.h \
 ../../src/kernel/miscFuncs.h ../../src/kernel/logNew.h \
 ../../src/kernel/Error.h ../../src/kernel/DataStruct.h \
 ../../src/kernel/type.h ../../src/kernel/isa.h \
 ../../src/kernel/FlagArray.h ../../src/kernel/SimControl.h \
 ../../src/kernel/InvokeInterp.h
