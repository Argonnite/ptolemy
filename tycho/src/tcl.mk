# Stub makefile: Rules for tcl, configure substitutes inside @...@  
#
# @Author: Christopher Hylands
#
# @Version: @(#)tcl.mk.in	1.7 05/25/97
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

# This makefile is an autoconf makefile, not a standard Ptolemy makefile

# If this file is named tycho/src/tcl.mk, DON'T EDIT IT.  Instead,
# do 'cd $TYCHO; make config_tclexts', which will create 
# tycho/obj.$PTARCH/tcl.mk. 
# tycho/src/tcl.mk exists so we can run 'make sources' in the
# tycho/src directory.

SHELL = 	/bin/sh

# Don't set srcdir or VPATH in this file or you will override the values
# in the makefile that includes this file.
#srcdir =	.
#VPATH =		.

# Location of Tcl and Tk files
TCL_SRC_DIR =		/export/carson/carson3/ptolemy/src/tcltk/itcl3.0a1/tcl8.0
TCL_INCLUDE_DIR =	/users/ptdesign/tcltk/itcl/include
TCL_LIB_DIR =		/users/ptdesign/tcltk/itcl.sol2.5/lib

TCL_SHLIB_SUFFIX =	.so
TCL_SHLIB_LD =		gcc -shared -fPIC

TCL_CFLAGS =		

# String to pass to linker to pick up the Tcl library from its
# installed directory.
TCL_LIB_SPEC =		-L/users/ptdesign/tcltk/itcl.sol2.5/lib -ltcl8.0

TK_INCLUDE_DIR =	/users/ptdesign/tcltk/itcl/include
TK_LIB_DIR =		/users/ptdesign/tcltk/itcl.sol2.5/lib

LIB_INSTALL_DIR =	$(TCL_LIB_DIR)
# Flags to pass to cc, such as "-Wl,-R,/usr/local/tcl/lib", that tell the
# run-time dynamic linker where to look for shared libraries such as
# libtcl.so.  Used when linking applications.  Only works if there
# is a variable "LIB_INSTALL_DIR" defined in the Makefile.
TCL_LD_SEARCH_FLAGS =	-R ${LIB_RUNTIME_DIR}

TK_SRC_DIR =		/export/carson/carson3/ptolemy/src/tcltk/itcl3.0a1/tcl8.0/../tk4.2

# -I switch(es) to use to make all of the X11 include files accessible:
TK_XINCLUDES =		-I/usr/openwin/include

# String to pass to linker to pick up the Tk library from its
# installed directory.
TK_LIB_SPEC =		-L/users/ptdesign/tcltk/itcl.sol2.5/lib -ltk8.0

# Additional libraries to use when linking Tk.
TK_LIBS =		-lX11 -ldl  -lsocket -lnsl -lm

CC =			gcc
AC_FLAGS =		 -DSTDC_HEADERS=1 -DHAVE_FCNTL_H=1 -DHAVE_VPRINTF=1  -fPIC 

# configure substitutes the stuff inside @..@ above this line

LIBS = 		$(TK_LIB_SPEC) $(TCL_LIB_SPEC) $(TK_LIBS)

TCL_INCLUDES = \
	-I$(TCL_INCLUDE_DIR) \
	-I$(TK_INCLUDE_DIR) \
	$(TK_XINCLUDES)

CFLAGS =	$(TCL_CFLAGS) $(AC_FLAGS) $(INCLUDE) $(OTHERCFLAGS)
