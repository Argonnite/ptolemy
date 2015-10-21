/*******************************************************************
SCCS version identification
@(#)xgout.h	1.4 3/2/95

Copyright (c) 1990-1995 The Regents of the University of California.
All rights reserved.

Permission is hereby granted, without written agreement and without
license or royalty fees, to use, copy, modify, and distribute this
software and its documentation for any purpose, provided that the
above copyright notice and the following two paragraphs appear in all
copies of this software.

IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY
FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES
ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
SUCH DAMAGE.

THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY WARRANTIES,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
CALIFORNIA HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES,
ENHANCEMENTS, OR MODIFICATIONS.

						PT_COPYRIGHT_VERSION_2
						COPYRIGHTENDKEY
*/
/*
 * Output Device Information
 *
 * This file contains definitions for output device interfaces
 * to the graphing program xgraph.
 */

#include "xgraph.h"

/* Passed device option flags */
#define D_DOCU		0x01

/* Returned device capability flags */
#define D_COLOR		0x01

/* Text justifications */
#define T_CENTER	0
#define T_LEFT		1
#define T_UPPERLEFT	2
#define T_TOP		3
#define T_UPPERRIGHT	4
#define T_RIGHT		5
#define T_LOWERRIGHT	6
#define T_BOTTOM	7
#define T_LOWERLEFT	8

/* Text styles */
#define T_AXIS		0
#define T_TITLE		1

/* Line Styles */
#define L_AXIS		0
#define L_ZERO		1
#define L_VAR		2

/* Marker Styles */
#define P_PIXEL		0
#define P_DOT		1
#define P_MARK		2

/* Output device information returned by initialization routine */

typedef struct xg_out {
    int dev_flags;		/* Device characteristic flags           */
    int area_w, area_h;		/* Width and height in pixels            */
    int bdr_pad;		/* Padding from border                   */
    int axis_pad;		/* Extra space around axis labels        */
    int tick_len;		/* Length of tick mark on axis           */
    int legend_pad;		/* Top of legend text to legend line     */
    int axis_width;		/* Width of big character of axis font   */
    int axis_height;		/* Height of big character of axis font  */
    int title_width;		/* Width of big character of title font  */
    int title_height;		/* Height of big character of title font */
    int max_segs;		/* Maximum number of segments in group   */

    void (*xg_text)();		/* Draws text at a location              */
    void (*xg_seg)();		/* Draws a series of segments            */
    void (*xg_dot)();		/* Draws a dot or marker at a location   */
    void (*xg_end)();		/* Stops the drawing sequence            */

    char *user_state;		/* User supplied data                    */
} xgOut;

#define ERRBUFSIZE	2048
