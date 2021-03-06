# Makefile for ptolemy language processor
# Version identification:
# @(#)make.template	1.29 09/17/99
# Copyright (c) 1990-1999 The Regents of the University of California.
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

ROOT = ../../..
VPATH = $(ROOT)/src/utils/ptplay
BINDIR = $(ROOT)/bin.$(PTARCH)

# get configuration info
CONFIG=$(ROOT)/mk/config-$(PTARCH).mk
include $(CONFIG)

SRCS = 	ptplay.sol2.c

EXTRA_DESTS =	ptplay.sun4 ptplay.irix5 ptplay.irix5.cfront \
	ptplay.irix6 ptplay.irix6.cfront \
	ptplay.hppa ptplay.linux ptplay.linux.debug ptplay.linux.static \
	ptplay.cfront ptplay.sol2 ptplay.sol2.cfront ptplay.irix4 \
	ptplay.hppa.cfront ptplay.hppa9 ptplay.freebsd \
	ptplay.sol2.5 ptplay.sol2.5.cfront \
	ptplay.sol2.6 ptplay.sol2.6.cfront \
	ptplay.sol7 ptplay.sol7.cfront \

KRUFT = ptplay.sol2 ptplay	

# common.mk wants this, otherwise we get multiple targets for $(LIBDIR)/$(PTLIB)
PTLIB = foo

all:	makefile ptplay
install:	ptplay $(BINDIR)/ptplay

# This is ugly, but effective.
# We don't want to create a dummy ptplay script for architecture that
# do not support ptplay because the stars look for the ptplay binary.

ifneq (,$(findstring sol, $(PTARCH)))
ptplay: ptplay.sol2
	echo 
	cp ptplay.sol2 ptplay
else
ptplay: ptplay.$(PTARCH) 
	@if [ $(PTARCH) = "mips" -o $(PTARCH) = "unixware" -o $(PTARCH) = "nt4" -o $(PTARCH) = "nt4.vc" ]; then \
		echo "$(PTARCH) architecture does not have a ptplay (yet)."; \
	else \
		echo "Copying $^ to $@"; \
		rm -f ptplay; \
		cp $^ $@; \
		chmod a+x $@; \
	fi
endif


$(BINDIR)/ptplay:	ptplay
	@if [ $(PTARCH) = "mips" -o $(PTARCH) = "unixware" -o $(PTARCH) = "nt4" -o $(PTARCH) = "nt4.vc" ]; then \
		echo "$(PTARCH) architecture does not have a ptplay (yet)."; \
	else \
		echo "Linking ptplay into $(BINDIR)"; \
		rm -f $(BINDIR)/ptplay; ln ptplay $(BINDIR); \
	fi


ptplay.nt4 ptplay.nt4.vc ptplay.mips ptplay.unixware ptplay.alpha4:
	@echo "$(PTARCH) architecture does not have a ptplay (yet)."

ptplay.cfront:  ptplay.sun4
	ln -s $^ $@ 
ptplay.irix4: ptplay.irix5
	ln -s $^ $@ 
ptplay.irix6: ptplay.irix5
	ln -s $^ $@ 
ptplay.irix6.cfront: ptplay.irix5
	ln -s $^ $@ 
ptplay.hppa.cfront: ptplay.hppa
	ln -s $^ $@ 
ptplay.hppa9: ptplay.hppa
	ln -s $^ $@ 
ptplay.linux.debug: ptplay.linux
	ln -s $^ $@ 
ptplay.linux.static: ptplay.linux
	ln -s $^ $@ 

C_INCL =	$(PTCOMPAT_INCSPEC)
ptplay.sol2 ptplay.sol2.5 ptplay.sol2.6 ptplay.sol7: ptplay.sol2.o

ptplay.sol2.cfront ptplay.sol2.5.cfront ptplay.sol2.6.cfront ptplay.sol7.cfront: ptplay.sol2.o 
	$(CC) $^ -o $@

#clean:
#	rm -f ptplay
#
#depend:
#	echo no dependencies to make in this directory
#
#checkjunk:
#	@checkextra -v $(SRCS) $(HDRS) $(EXTRA_SRCS) \
#		$(EXTRA_DESTS) makefile SCCS
#
#sccsinfo:
#	@sccs check || true
#
#sources: $(SRCS) 

# include common definitions, rules
include $(ROOT)/mk/common.mk


# Don't add anything after the next line; makedepend will zap it.
# DO NOT DELETE THIS LINE -- make depend depends on it.


ptplay.sol2.o: ptplay.sol2.c ../../../src/compat/ptolemy/compat.h
