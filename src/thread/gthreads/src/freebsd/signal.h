/* Copyright (C) 1992, 1993, 1994, 1995, 1996 the Florida State University
   Distributed by the Florida State University under the terms of the
   GNU Library General Public License.

This file is part of Pthreads.

Pthreads is free software; you can redistribute it and/or
modify it under the terms of the GNU Library General Public
License as published by the Free Software Foundation (version 2).

Pthreads is distributed "AS IS" in the hope that it will be
useful, but WITHOUT ANY WARRANTY; without even the implied
warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
See the GNU Library General Public License for more details.

You should have received a copy of the GNU Library General Public
License along with Pthreads; see the file COPYING.  If not, write
to the Free Software Foundation, 675 Mass Ave, Cambridge,
MA 02139, USA.

Report problems and direct all questions to:

  pthreads-bugs@ada.cs.fsu.edu

  @(#)signal.h	3.1 10/11/96

*/

#if !defined (_FREEBSD_SIGNAL_H_)
#define _FREEBSD_SIGNAL_H_

#include <sys/cdefs.h>

#ifndef KERNEL
#include <sys/types.h>


__BEGIN_DECLS

#ifndef _ANSI_SOURCE
#define SYS_SIGACTION     pthread_sigaction
#define SYS_SIGPROCMASK   pthread_sigprocmask
#define SYS_SIGSUSPEND    pthread_sigsuspend

int     pthread_sigaction __P((int, const struct sigaction *
                               , struct sigaction *));
int     pthread_sigprocmask __P((int, const sigset_t *, sigset_t *));
int     pthread_sigsuspend __P((const sigset_t *));
#endif /* !_ANSI_SOURCE */

__END_DECLS

#endif /* !KERNEL */
#endif /* !_FREEBSD_SIGNAL_H_ */
