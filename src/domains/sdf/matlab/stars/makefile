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
# Makefile for Ptolemy SDF matlab/stars
# Author: Christopher Hylands
# @(#)make.template	1.13 20 Sep 1996
#
# We build two libraries:  libsdfmatlab and libsdfnomatlab.
# libsdfmatlab contains unresolved symbols that are resolved by the matlab
# library libmat.a.
# libsdfnomatlab contains no unresolved symbols, the stars inside it merely
# bring up windows stating that you must compile Ptolemy with matlab.
#
# If this file's name is "make.template" and there is no makefile in
# this directory, do
#	cp make.template makefile
#	chmod +w makefile
#	make depend
# This will add the dependencies to the makefile.

ROOT = ../../../../..
VPATH = $(ROOT)/src/domains/sdf/matlab/stars

# get configuration info
CONFIG=$(ROOT)/mk/config-$(PTARCH).mk
include $(CONFIG)

# SDFDIR is the directory containing SDF domain support
SDFDIR = $(ROOT)/src/domains/sdf/kernel
INCL = $(PTCOMPAT_INCSPEC) -I$(SDFDIR) -I$(KERNDIR) \
       $(MATLAB_INCSPEC) $(MATLABIFC_INCSPEC)

# Library name
PTLIB=libsdfmatlabstars.$(LIBSUFFIX)

# source files for all stars, using preprocessor
PL_SRCS= \
  SDFMatlab.pl \
  SDFMatlab_M.pl \
  SDFMatlabCx_M.pl

# The .cc files
SRCS=$(PL_SRCS:.pl=.cc)

# object files for all stars
OBJS= $(SRCS:.cc=.o)

# header files for all stars
HDRS= $(SRCS:.cc=.h)

# common.mk uses this to override the MATLAB makefile variables so that
# we build a binary that does not have matlab 
#DONT_USE_MATLAB =	yes

STAR_MK=sdfmatlabstars
DOMAIN=SDF_MATRIX
DOMAIN_2=SDF
EXTRA_SRCS=$(STAR_MK).c $(PL_SRCS)

all:		$(SRCS) stars_all

install:	stars_install

# matlab.mk checks this var before traversing the path
NEED_MATLABDIR =	1

# include common definitions, rules
include $(ROOT)/mk/common.mk

# Workaround bug in gcc-2.7.2 optimizer
ifeq ($(USE_GPLUSPLUS),yes)
SDFMatlabCx_M.o: SDFMatlabCx_M.cc
	$(UNOPTIMIZED_WARNING_MESSAGE)
	$(UNOPTIMIZED_COMPILE_RULE) $<
endif

# Don't add anything after the next line; makedepend will zap it.
# DO NOT DELETE THIS LINE -- make depend depends on it.

SDFMatlab.o: SDFMatlab.cc SDFMatlab.h \
 ../../../../../src/utils/libexttools/MatlabPtIfc.h \
 ../../../../../src/kernel/Matrix.h \
 ../../../../../src/kernel/Message.h \
 ../../../../../src/kernel/Particle.h \
 ../../../../../src/kernel/StringList.h \
 ../../../../../src/kernel/miscFuncs.h \
 ../../../../../src/kernel/logNew.h ../../../../../src/kernel/Error.h \
 ../../../../../src/kernel/DataStruct.h \
 ../../../../../src/kernel/type.h ../../../../../src/kernel/dataType.h \
 ../../../../../src/kernel/Fix.h \
 ../../../../../src/kernel/ComplexSubset.h \
 ../../../../../src/kernel/isa.h \
 ../../../../../src/kernel/ComplexArrayState.h \
 ../../../../../src/kernel/State.h \
 ../../../../../src/kernel/InvokeInterp.h \
 ../../../../../src/kernel/NamedObj.h \
 ../../../../../src/kernel/FlagArray.h \
 ../../../../../src/kernel/Attribute.h \
 ../../../../../src/kernel/FixArrayState.h \
 ../../../../../src/kernel/PrecisionState.h \
 ../../../../../src/kernel/FloatArrayState.h \
 ../../../../../src/kernel/IntArrayState.h \
 ../../../../../src/kernel/PortHole.h \
 ../../../../../src/utils/libexttools/MatlabIfc.h \
 ../../../../../src/kernel/InfString.h \
 ../../../../../src/utils/libexttools/MatlabIfcFuns.h \
 ../../../../../src/compat/ptolemy/compat.h \
 ../../../../../src/utils/libexttools/MatlabIfc.h.Auto \
 ../../../../../src/domains/sdf/kernel/SDFStar.h \
 ../../../../../src/kernel/DataFlowStar.h \
 ../../../../../src/kernel/Star.h ../../../../../src/kernel/Block.h \
 ../../../../../src/kernel/Fraction.h \
 ../../../../../src/domains/sdf/kernel/SDFPortHole.h \
 ../../../../../src/kernel/DFPortHole.h \
 ../../../../../src/kernel/IntState.h \
 ../../../../../src/kernel/StringState.h \
 ../../../../../src/kernel/KnownState.h
SDFMatlab_M.o: SDFMatlab_M.cc SDFMatlab_M.h \
 ../../../../../src/kernel/dataType.h \
 ../../../../../src/kernel/Matrix.h \
 ../../../../../src/kernel/Message.h \
 ../../../../../src/kernel/Particle.h \
 ../../../../../src/kernel/StringList.h \
 ../../../../../src/kernel/miscFuncs.h \
 ../../../../../src/kernel/logNew.h ../../../../../src/kernel/Error.h \
 ../../../../../src/kernel/DataStruct.h \
 ../../../../../src/kernel/type.h ../../../../../src/kernel/Fix.h \
 ../../../../../src/kernel/ComplexSubset.h \
 ../../../../../src/kernel/isa.h \
 ../../../../../src/kernel/ComplexArrayState.h \
 ../../../../../src/kernel/State.h \
 ../../../../../src/kernel/InvokeInterp.h \
 ../../../../../src/kernel/NamedObj.h \
 ../../../../../src/kernel/FlagArray.h \
 ../../../../../src/kernel/Attribute.h \
 ../../../../../src/kernel/FixArrayState.h \
 ../../../../../src/kernel/PrecisionState.h \
 ../../../../../src/kernel/FloatArrayState.h \
 ../../../../../src/kernel/IntArrayState.h \
 ../../../../../src/kernel/PortHole.h \
 ../../../../../src/utils/libexttools/MatlabPtIfc.h \
 ../../../../../src/utils/libexttools/MatlabIfc.h \
 ../../../../../src/kernel/InfString.h \
 ../../../../../src/utils/libexttools/MatlabIfcFuns.h \
 ../../../../../src/compat/ptolemy/compat.h \
 ../../../../../src/utils/libexttools/MatlabIfc.h.Auto SDFMatlab.h \
 ../../../../../src/domains/sdf/kernel/SDFStar.h \
 ../../../../../src/kernel/DataFlowStar.h \
 ../../../../../src/kernel/Star.h ../../../../../src/kernel/Block.h \
 ../../../../../src/kernel/Fraction.h \
 ../../../../../src/domains/sdf/kernel/SDFPortHole.h \
 ../../../../../src/kernel/DFPortHole.h \
 ../../../../../src/kernel/IntState.h \
 ../../../../../src/kernel/StringState.h \
 ../../../../../src/kernel/KnownState.h
SDFMatlabCx_M.o: SDFMatlabCx_M.cc SDFMatlabCx_M.h SDFMatlab_M.h \
 ../../../../../src/kernel/dataType.h \
 ../../../../../src/kernel/Matrix.h \
 ../../../../../src/kernel/Message.h \
 ../../../../../src/kernel/Particle.h \
 ../../../../../src/kernel/StringList.h \
 ../../../../../src/kernel/miscFuncs.h \
 ../../../../../src/kernel/logNew.h ../../../../../src/kernel/Error.h \
 ../../../../../src/kernel/DataStruct.h \
 ../../../../../src/kernel/type.h ../../../../../src/kernel/Fix.h \
 ../../../../../src/kernel/ComplexSubset.h \
 ../../../../../src/kernel/isa.h \
 ../../../../../src/kernel/ComplexArrayState.h \
 ../../../../../src/kernel/State.h \
 ../../../../../src/kernel/InvokeInterp.h \
 ../../../../../src/kernel/NamedObj.h \
 ../../../../../src/kernel/FlagArray.h \
 ../../../../../src/kernel/Attribute.h \
 ../../../../../src/kernel/FixArrayState.h \
 ../../../../../src/kernel/PrecisionState.h \
 ../../../../../src/kernel/FloatArrayState.h \
 ../../../../../src/kernel/IntArrayState.h \
 ../../../../../src/kernel/PortHole.h \
 ../../../../../src/utils/libexttools/MatlabPtIfc.h \
 ../../../../../src/utils/libexttools/MatlabIfc.h \
 ../../../../../src/kernel/InfString.h \
 ../../../../../src/utils/libexttools/MatlabIfcFuns.h \
 ../../../../../src/compat/ptolemy/compat.h \
 ../../../../../src/utils/libexttools/MatlabIfc.h.Auto SDFMatlab.h \
 ../../../../../src/domains/sdf/kernel/SDFStar.h \
 ../../../../../src/kernel/DataFlowStar.h \
 ../../../../../src/kernel/Star.h ../../../../../src/kernel/Block.h \
 ../../../../../src/kernel/Fraction.h \
 ../../../../../src/domains/sdf/kernel/SDFPortHole.h \
 ../../../../../src/kernel/DFPortHole.h \
 ../../../../../src/kernel/IntState.h \
 ../../../../../src/kernel/StringState.h \
 ../../../../../src/kernel/KnownState.h
