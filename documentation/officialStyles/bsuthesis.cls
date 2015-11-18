% This file was created by Alex Feldman, augmenting an earlier effort
% by Amit Jain.  It uses many of the same options that can be found in
% the standard LaTeX classes article, report, and book, including many
% which are not probably necessary, like "a5paper".

% Some design decisions for the file:

%   There is no LaTeX 2.09 compatibility mode

\typeout{Boise State University thesis class  1 October, 2007}

\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{bsuthesis}[2007/10/01 LaTeX class for Boise State University]

\usepackage{setspace}

% Here is a macro from the TeXbook that I use

\def\ifundefined#1{\expandafter\ifx\csname#1\endcsname\relax}


% This is the section where the options are defined.

\newcommand\@ptsize{}
\newif\if@restonecol
\newif\if@openright

\DeclareOption{a4paper}
   {\setlength\paperheight {297mm}%
    \setlength\paperwidth  {210mm}}
\DeclareOption{a5paper}
   {\setlength\paperheight {210mm}%
    \setlength\paperwidth  {148mm}}
\DeclareOption{b5paper}
   {\setlength\paperheight {250mm}%
    \setlength\paperwidth  {176mm}}
\DeclareOption{letterpaper}
   {\setlength\paperheight {11in}%
    \setlength\paperwidth  {8.5in}}
\DeclareOption{legalpaper}
   {\setlength\paperheight {14in}%
    \setlength\paperwidth  {8.5in}}
\DeclareOption{executivepaper}
   {\setlength\paperheight {10.5in}%
    \setlength\paperwidth  {7.25in}}
\DeclareOption{landscape}
   {\setlength\@tempdima   {\paperheight}%
    \setlength\paperheight {\paperwidth}%
    \setlength\paperwidth  {\@tempdima}}

\DeclareOption{10pt}{\renewcommand\@ptsize{0}}
\DeclareOption{11pt}{\renewcommand\@ptsize{1}}
\DeclareOption{12pt}{\renewcommand\@ptsize{2}}

\DeclareOption{oneside}{\@twosidefalse \@mparswitchfalse}
\DeclareOption{twoside}{\@twosidetrue  \@mparswitchtrue}
\DeclareOption{draft}{\setlength\overfullrule{5pt}}
\DeclareOption{final}{\setlength\overfullrule{0pt}}

\DeclareOption{openright}{\@openrighttrue}
\DeclareOption{openany}{\@openrightfalse}

\DeclareOption{onecolumn}{\@twocolumnfalse}
\DeclareOption{twocolumn}{\@twocolumntrue}

\DeclareOption{leqno}{\input{leqno.clo}}
\DeclareOption{fleqn}{\input{fleqn.clo}}

\DeclareOption{openbib}{%
  \AtEndOfPackage{%
   \renewcommand\@openbib@code{%
      \advance\leftmargin\bibindent
      \itemindent -\bibindent
      \listparindent \itemindent
      \parsep \z@
      }%
   \renewcommand\newblock{\par}}%
}

% Here is where we set the default options.

\ExecuteOptions{letterpaper,12pt,twoside,onecolumn,final,openany}
\ProcessOptions\relax

% I am temporarily using the existing .clo files (size10.clo,
% size11.clo, size12.clo) to set margins, etc.  This will probably
% change when everything is brought up to grad school standards,
% although there is really no harm in keeping it here.  Everything
% just gets redefined.

%\setstretch{1.7}
\input{size1\@ptsize.clo}

\normalsize 

%% This file is intended to be used with letter size paper.
%% Frequently, one of the programs used after TeX for processing, like
%% ghostview or dvipdf, will default to A4 rather than letter.  These
%% commented out values worked when ghostview was set to A4.  Using
%% them is a kludge, you should set everything up to run with letter,
%% but they are provided in the hope that they might be useful.

% \setlength{\evensidemargin}{59pt}      %Probably wrong - check dimensions.
% \setlength{\topmargin}{0in}

%%  Here are the proper lengths if everything is set up right.

\setlength{\topmargin}{.7in}
\setlength{\headsep}{0.25in}

\setlength{\oddsidemargin}{0.5625in}
\setlength{\evensidemargin}{\oddsidemargin}
\setlength{\textwidth}{6.0in}
\setlength{\textheight}{8.5in}

\setlength\lineskip{1\p@}
\setlength\normallineskip{1\p@}
\renewcommand\baselinestretch{}
\setlength\parskip{0\p@ \@plus \p@}
\setlength\parindent{1.5em}
\setlength\partopsep{3\p@ \@plus 2\p@ \@minus 2\p@}
\@lowpenalty   51
\@medpenalty  151
\@highpenalty 301

\setcounter{topnumber}{2}
\renewcommand\topfraction{.7}
\setcounter{bottomnumber}{1}
\renewcommand\bottomfraction{.3}
\setcounter{totalnumber}{3}
\renewcommand\textfraction{.2}
\renewcommand\floatpagefraction{.5}
\setcounter{dbltopnumber}{2}
\renewcommand\dbltopfraction{.7}
\renewcommand\dblfloatpagefraction{.5}

%%  Shouldn't need any of the twopage stuff, but I'm leaving it
%%  commented out for now, it should probably be removed eventually.
%%  Similarly for some commented out lines I have changed below that.

%\if@twoside
%  \def\ps@headings{%
%      \let\@oddfoot\@empty\let\@evenfoot\@empty
%      \def\@evenhead{\thepage\hfil\slshape\leftmark}%
%      \def\@oddhead{{\slshape\rightmark}\hfil\thepage}%
%      \let\@mkboth\markboth
%    \def\chaptermark##1{%
%      \markboth {\MakeUppercase{%
%        \ifnum \c@secnumdepth >\m@ne
%            \@chapapp\ \thechapter. \ %
%        \fi
%        ##1}}{}}%
%    \def\sectionmark##1{%
%      \markright {\MakeUppercase{%
%        \ifnum \c@secnumdepth >\z@
%          \thesection. \ %
%        \fi
%        ##1}}}}
%\else
  \def\ps@headings{%
    \let\@oddfoot\@empty
%    \def\@oddhead{{\slshape\rightmark}\hfil\thepage}%
\def\@oddhead{\hbox{}\hfil\thepage}
    \let\@mkboth\markboth
    \def\chaptermark##1{%
      \markright {\MakeUppercase{%
        \ifnum \c@secnumdepth >\m@ne
            \@chapapp\ \thechapter. \ %
        \fi
        ##1}}}}
%\fi

%
\def\ps@myheadings{\let\@mkboth\@gobbletwo
%\def\@oddhead{\hbox{}\slshape\rightmark \hfil
\def\@oddhead{\hbox{} \hfil\rmfamily\thepage}
\def\@oddfoot{}
%\def\@evenhead{\rmfamily \thepage\hfil\slshape\leftmark\hbox{}}
\def\@evenhead{\hbox{} \hfil\rmfamily\thepage}
\def\@evenfoot{}
\def\chaptermark##1{}
\def\sectionmark##1{}%
\def\subsectionmark##1{}}


%
% Here is where I define the titlepage.  This is a place where there
% may be errors, since in this classfile it is not optional, although
% it usually is.  It may be possible to clean up this code a bit.

\def\gyear#1{\gdef\@gyear{#1}}
\gdef\@gyear{\number\year}
\def\gmonth#1{\gdef\@gmonth{#1}}
\gdef\@gmonth{\number\month}


\def\degree#1{\gdef\@degree{#1}}
\def\masterstype#1{\gdef\@masterstype{#1}}
\gdef\@masterstype{thesis}

\def\cmteA#1{\gdef\@cmteA{#1}}
\def\cmteB#1{\gdef\@cmteB{#1}}
\def\cmteC#1{\gdef\@cmteC{#1}}
\def\cmteD#1{\gdef\@cmteD{#1}}
\def\advisor#1{\gdef\@advisor{#1}}
\def\defensedate#1{\gdef\@defensedate{#1}}
\def\approvaldate#1{\gdef\@approvaldate{#1}}

% I have removed most of the defaults from here.  To put them back,
% copy what is done for the Graduate Dean.

\def\major#1{\gdef\@major{#1}}
\def\dept#1{\gdef\@dept{#1}}
\def\deptchair#1{\gdef\@deptchair{#1}}

% Graduate Program Coordinator (optional) - probably should go away.
\def\gpc#1{\gdef\@gpc{#1}}
\def\college#1{\gdef\@college{#1}}
\def\graddean#1{\gdef\@graddean{#1}}
\gdef\@graddean{John R. Pelton}

\def\makeline#1{\underline{\hspace*{#1}}}

\newcommand\maketitle{\begin{titlepage}%
%  \null\newpage
  \let\footnotesize\small
  \let\footnoterule\relax
  \setcounter{page}{1}
  \setlength{\parindent}{0ex}
  \null
  \vspace{1ex}
  \begin{center}
   \begin{doublespace}\setstretch{1.7}
   {\large\bfseries{\uppercase\expandafter{\@title}} \par} 
	\end{doublespace}
%   \vskip 2.1in                  % Vertical space after title.
     \vfil
   \begin{doublespace}\setstretch{1.7}
   { 
     {by \par}
	 \vskip 1ex
     \begin{tabular}[t]{c}{\@author} 
     \end{tabular}\par
   }      
\vskip 1.3in               % Vertical space after author.
   A \@masterstype\\
   { submitted in partial fulfillment\\
     of the requirements for the degree of\\
	 Master of Science in \@dept \\
	 Boise State University\par
   }
	\end{doublespace}
   \vskip 0.3in
   \vfil
   {\@gmonth\ \@gyear \par} 
   \end{center} 
%   \@thanks
   \par
   \null
   \setlength{\parindent}{3ex}
  \end{titlepage}%
  \setcounter{footnote}{0}%
  \global\let\thanks\relax
  \global\let\maketitle\relax
  \global\let\title\relax
  \global\let\author\relax
  \global\let\date\relax
  \global\let\and\relax
}


\def\makeapproval{\begin{titlepage}
 \setlength{\parindent}{0ex}
 \setlength{\parskip}{0ex}
 %{\if@makecopyright \setcounter{page}{3} \else \setcounter{page}{2} \fi}
 % should check if a copyright page is there or not 
 % before setting page counter...
 \setcounter{page}{3}

	
 {\raggedright
 \vskip 2in
	The {\@masterstype } presented by {\em \@author} entitled {\em \@title}
	is hereby approved.
 }
	
	\vskip 1.5in

	\hfill \makeline{4.5in} \\
    \null \hfill {\makebox[4.5in][l]{\hspace*{4ex}\@advisor, Advisor \hfill
	Date \hspace*{4ex}}}\\[24pt]
	\mbox{}\hfill \makeline{4.5in} \\
    \null \hfill \makebox[4.5in][l]{\hspace*{4ex}\@cmteA, 
        Committee Member \hfill Date \hspace*{4ex}}\\[24pt]
	\mbox{}\hfill \makeline{4.5in} \\
    \null \hfill \makebox[4.5in][l]{\hspace*{4ex}\@cmteB, 
        Committee Member \hfill Date \hspace*{4ex}}\\[24pt]
	\mbox{}\hfill \makeline{4.5in} \\
    \ifundefined{@cmteC}
    \else\null \hfill \makebox[4.5in][l]{\hspace*{4ex}\@cmteC, 
        Committee Member \hfill Date \hspace*{4ex}}\\[24pt]
	\mbox{}\hfill \makeline{4.5in} \\
\fi
    \ifundefined{@cmteD}
    \else\null \hfill \makebox[4.5in][l]{\hspace*{4ex}\@cmteD, 
        Committee Member \hfill Date \hspace*{4ex}}\\[24pt]
	\mbox{}\hfill \makeline{4.5in} \\
\fi
        \null \hfill \makebox[4.5in][l]{\hspace*{4ex}\@graddean, 
        Graduate Dean \hfill Date
	\hspace*{4ex}}

\setlength{\parindent}{3ex}
\end{titlepage}
}
\def\biosketch{\newpage
\null \vskip 1.5ex
\begin{center}
{\large\bfseries AUTOBIOGRAPHICAL SKETCH}
\end{center}\hspace*{3ex}}
\def\endabstract{\par\vfil\null}

\def\abstract{\newpage
\null \vskip 1.5ex
\begin{center}
{\large\bfseries ABSTRACT}
\end{center}\hspace*{3ex}}

\def\endabstract{\par\vfil\null}


% dedication:
\def\dedication{\newpage
\vspace*{-1.5in}
\null\vfil}

\def\enddedication{\par\vfil\null}

% acknowledgements
\def\acknowledgements{\newpage
\null \vskip 1.5ex
\begin{center}
{\large\bfseries ACKNOWLEDGEMENTS}
\end{center}\hspace*{3ex}}

\def\endacknowledgements{\par\vfil\null}

\def\makecopyright{\begin{titlepage}
 \setcounter{page}{2}
 \setlength{\parindent}{0ex}
 \setlength{\parskip}{0ex}
 \null
 \vfill
 \begin{center}
 {$\copyright$ \number\year \par \@author}

 {\scshape ALL RIGHTS RESERVED}
 \end{center}
\setlength{\parindent}{3ex}
\end{titlepage}

\let\maketitle\relax\let\makecopyright\relax}


% This is a monolithic paste from report.cls.  At the very end
% onepage, twocolumn stuff is left out.

\newcommand*\chaptermark[1]{}
\setcounter{secnumdepth}{2}
\newcounter {part}
\newcounter {chapter}
\newcounter {section}[chapter]
\newcounter {subsection}[section]
\newcounter {subsubsection}[subsection]
\newcounter {paragraph}[subsubsection]
\newcounter {subparagraph}[paragraph]
\renewcommand \thepart {\@Roman\c@part}
\renewcommand \thechapter {\@arabic\c@chapter}
\renewcommand \thesection {\thechapter.\@arabic\c@section}
\renewcommand\thesubsection   {\thesection.\@arabic\c@subsection}
\renewcommand\thesubsubsection{\thesubsection .\@arabic\c@subsubsection}
\renewcommand\theparagraph    {\thesubsubsection.\@arabic\c@paragraph}
\renewcommand\thesubparagraph {\theparagraph.\@arabic\c@subparagraph}
\newcommand\@chapapp{\chaptername}
\newcommand\part{%
  \if@openright
    \cleardoublepage
  \else
    \clearpage
  \fi
  \thispagestyle{plain}%
  \if@twocolumn
    \onecolumn
    \@tempswatrue
  \else
    \@tempswafalse
  \fi
  \null\vfil
  \secdef\@part\@spart}

\def\@part[#1]#2{%
    \ifnum \c@secnumdepth >-2\relax
      \refstepcounter{part}%
      \addcontentsline{toc}{part}{\thepart\hspace{1em}#1}%
    \else
      \addcontentsline{toc}{part}{#1}%
    \fi
    \markboth{}{}%
    {\centering
     \interlinepenalty \@M
     \normalfont
     \ifnum \c@secnumdepth >-2\relax
       \Large\bfseries \partname\nobreakspace\thepart
       \par
       \vskip 20\p@
     \fi
     \Large \bfseries #2\par}%
    \@endpart}
\def\@spart#1{%
    {\centering
     \interlinepenalty \@M
     \normalfont
     \Large \bfseries #1\par}%
    \@endpart}
\def\@endpart{\vfil\newpage
              \if@twoside
               \if@openright
                \null
                \thispagestyle{empty}%
                \newpage
               \fi
              \fi
              \if@tempswa
                \twocolumn
              \fi}
\newcommand\chapter{\if@openright\cleardoublepage\else\clearpage\fi
                    \global\@topnum\z@
                    \@afterindentfalse
                    \secdef\@chapter\@schapter}
\def\@chapter[#1]#2{\ifnum \c@secnumdepth >\m@ne
                         \refstepcounter{chapter}%
                         \typeout{\@chapapp\space\thechapter.}%
                         \addcontentsline{toc}{chapter}%
                                   {\protect\numberline{\thechapter}#1}%
                    \else
                      \addcontentsline{toc}{chapter}{#1}%
                    \fi
                    \chaptermark{#1}%
                    \addtocontents{lof}{\protect\addvspace{10\p@}}%
                    \addtocontents{lot}{\protect\addvspace{10\p@}}%
                    \if@twocolumn
                      \@topnewpage[\@makechapterhead{#2}]%
                    \else
                      \@makechapterhead{#2}%
                      \@afterheading
                    \fi}
\def\@makechapterhead#1{%
  \vspace*{10\p@}%
  {\parindent \z@ \raggedright \normalfont
    \ifnum \c@secnumdepth >\m@ne
       \centering
        \Large\bfseries \@chapapp\space \thechapter
      \par\nobreak
        \vskip 20\p@
    \fi
    \interlinepenalty\@M
    \Large \bfseries #1\par\nobreak
    \vskip 40\p@
  }}
\def\@schapter#1{\if@twocolumn
                   \@topnewpage[\@makeschapterhead{#1}]%
                 \else
                   \@makeschapterhead{#1}%
                   \@afterheading
                 \fi}
\def\@makeschapterhead#1{%
  \vspace*{50\p@}%
  {\parindent \z@ \raggedright
    \centering
    \normalfont
    \interlinepenalty\@M
    \Large \bfseries  #1\par\nobreak
    \vskip 40\p@
  }}
\newcommand\section{\@startsection {section}{1}{\z@}%
                                   {-3.5ex \@plus -1ex \@minus -.2ex}%
                                   {2.3ex \@plus.2ex}%
                                   {\normalfont\Large\bfseries}}
\newcommand\subsection{\@startsection{subsection}{2}{\z@}%
                                     {-3.25ex\@plus -1ex \@minus -.2ex}%
                                     {1.5ex \@plus .2ex}%
                                     {\normalfont\large\bfseries}}
\newcommand\subsubsection{\@startsection{subsubsection}{3}{\z@}%
                                     {-3.25ex\@plus -1ex \@minus -.2ex}%
                                     {1.5ex \@plus .2ex}%
                                     {\normalfont\normalsize\bfseries}}
\newcommand\paragraph{\@startsection{paragraph}{4}{\z@}%
                                    {3.25ex \@plus1ex \@minus.2ex}%
                                    {-1em}%
                                    {\normalfont\normalsize\bfseries}}
\newcommand\subparagraph{\@startsection{subparagraph}{5}{\parindent}%
                                       {3.25ex \@plus1ex \@minus .2ex}%
                                       {-1em}%
                                      {\normalfont\normalsize\bfseries}}
\if@twocolumn
  \setlength\leftmargini  {2em}
\else
  \setlength\leftmargini  {2.5em}
\fi
\leftmargin  \leftmargini
\setlength\leftmarginii  {2.2em}
\setlength\leftmarginiii {1.87em}
\setlength\leftmarginiv  {1.7em}
\if@twocolumn
  \setlength\leftmarginv  {.5em}
  \setlength\leftmarginvi {.5em}
\else
  \setlength\leftmarginv  {1em}
  \setlength\leftmarginvi {1em}
\fi
\setlength  \labelsep  {.5em}
\setlength  \labelwidth{\leftmargini}
\addtolength\labelwidth{-\labelsep}
\@beginparpenalty -\@lowpenalty
\@endparpenalty   -\@lowpenalty
\@itempenalty     -\@lowpenalty
\renewcommand\theenumi{\@arabic\c@enumi}
\renewcommand\theenumii{\@alph\c@enumii}
\renewcommand\theenumiii{\@roman\c@enumiii}
\renewcommand\theenumiv{\@Alph\c@enumiv}
\newcommand\labelenumi{\theenumi.}
\newcommand\labelenumii{(\theenumii)}
\newcommand\labelenumiii{\theenumiii.}
\newcommand\labelenumiv{\theenumiv.}
\renewcommand\p@enumii{\theenumi}
\renewcommand\p@enumiii{\theenumi(\theenumii)}
\renewcommand\p@enumiv{\p@enumiii\theenumiii}
\newcommand\labelitemi{\textbullet}
\newcommand\labelitemii{\normalfont\bfseries \textendash}
\newcommand\labelitemiii{\textasteriskcentered}
\newcommand\labelitemiv{\textperiodcentered}
\newenvironment{description}
               {\list{}{\labelwidth\z@ \itemindent-\leftmargin
                        \let\makelabel\descriptionlabel}}
               {\endlist}
\newcommand*\descriptionlabel[1]{\hspace\labelsep
                                \normalfont\bfseries #1}

% Getting rid of this to use the one built in the titlepage section

%  \newenvironment{abstract}{%
%      \titlepage
%      \null\vfil
%      \@beginparpenalty\@lowpenalty
%      \begin{center}%
%        \bfseries \abstractname
%        \@endparpenalty\@M
%      \end{center}}%
%     {\par\vfil\null\endtitlepage}

\newenvironment{verse}
               {\let\\\@centercr
                \list{}{\itemsep      \z@
                        \itemindent   -1.5em%
                        \listparindent\itemindent
                        \rightmargin  \leftmargin
                        \advance\leftmargin 1.5em}%
                \item\relax}
               {\endlist}
\newenvironment{quotation}
               {\list{}{\listparindent 1.5em%
                        \itemindent    \listparindent
                        \rightmargin   \leftmargin
                        \parsep        \z@ \@plus\p@}%
                \item\relax}
               {\endlist}
\newenvironment{quote}
               {\list{}{\rightmargin\leftmargin}%
                \item\relax}
               {\endlist}
\newenvironment{titlepage}
    {%
      \if@twocolumn
        \@restonecoltrue\onecolumn
      \else
        \@restonecolfalse\newpage
      \fi
      \thispagestyle{empty}%
      \setcounter{page}\@ne
    }%
    {\if@restonecol\twocolumn \else \newpage \fi
     \if@twoside\else
        \setcounter{page}\@ne
     \fi
    }
\newcommand\appendix{\par
  \setcounter{chapter}{0}%
  \setcounter{section}{0}%
  \gdef\@chapapp{\appendixname}%
  \gdef\thechapter{\@Alph\c@chapter}}
\setlength\arraycolsep{5\p@}
\setlength\tabcolsep{6\p@}
\setlength\arrayrulewidth{.4\p@}
\setlength\doublerulesep{2\p@}
\setlength\tabbingsep{\labelsep}
\skip\@mpfootins = \skip\footins
\setlength\fboxsep{3\p@}
\setlength\fboxrule{.4\p@}
\@addtoreset {equation}{chapter}
\renewcommand\theequation
  {\ifnum \c@chapter>\z@ \thechapter.\fi \@arabic\c@equation}
\newcounter{figure}[chapter]
\renewcommand \thefigure
     {\ifnum \c@chapter>\z@ \thechapter.\fi \@arabic\c@figure}
\def\fps@figure{tbp}
\def\ftype@figure{1}
\def\ext@figure{lof}
\def\fnum@figure{\figurename\nobreakspace\thefigure}
\newenvironment{figure}
               {\@float{figure}}
               {\end@float}
\newenvironment{figure*}
               {\@dblfloat{figure}}
               {\end@dblfloat}
\newcounter{table}[chapter]
\renewcommand \thetable
     {\ifnum \c@chapter>\z@ \thechapter.\fi \@arabic\c@table}
\def\fps@table{tbp}
\def\ftype@table{2}
\def\ext@table{lot}
\def\fnum@table{\tablename\nobreakspace\thetable}
\newenvironment{table}
               {\@float{table}}
               {\end@float}
\newenvironment{table*}
               {\@dblfloat{table}}
               {\end@dblfloat}
\newlength\abovecaptionskip
\newlength\belowcaptionskip
\setlength\abovecaptionskip{10\p@}
\setlength\belowcaptionskip{0\p@}
\long\def\@makecaption#1#2{%
  \vskip\abovecaptionskip
  \sbox\@tempboxa{#1: #2}%
  \ifdim \wd\@tempboxa >\hsize
    #1: #2\par
  \else
    \global \@minipagefalse
    \hb@xt@\hsize{\hfil\box\@tempboxa\hfil}%
  \fi
  \vskip\belowcaptionskip}
\DeclareOldFontCommand{\rm}{\normalfont\rmfamily}{\mathrm}
\DeclareOldFontCommand{\sf}{\normalfont\sffamily}{\mathsf}
\DeclareOldFontCommand{\tt}{\normalfont\ttfamily}{\mathtt}
\DeclareOldFontCommand{\bf}{\normalfont\bfseries}{\mathbf}
\DeclareOldFontCommand{\it}{\normalfont\itshape}{\mathit}
\DeclareOldFontCommand{\sl}{\normalfont\slshape}{\@nomath\sl}
\DeclareOldFontCommand{\sc}{\normalfont\scshape}{\@nomath\sc}
\DeclareRobustCommand*\cal{\@fontswitch\relax\mathcal}
\DeclareRobustCommand*\mit{\@fontswitch\relax\mathnormal}
\newcommand\@pnumwidth{1.55em}
\newcommand\@tocrmarg{2.55em}
\newcommand\@dotsep{4.5}
\setcounter{tocdepth}{2}
\newcommand\tableofcontents{%
      \@restonecolfalse
%    \chapter*{\contentsname
%        \@mkboth{%
%          \MakeUppercase\contentsname}{\MakeUppercase\contentsname}}%

\chapter*{TABLE OF CONTENTS\@mkboth{CONTENTS}{CONTENTS}}


    \@starttoc{toc}%
%    \if@restonecol\twocolumn\fi
    }
\newcommand*\l@part[2]{%
  \ifnum \c@tocdepth >-2\relax
    \addpenalty{-\@highpenalty}%
    \addvspace{2.25em \@plus\p@}%
    \setlength\@tempdima{3em}%
    \begingroup
      \parindent \z@ \rightskip \@pnumwidth
      \parfillskip -\@pnumwidth
      {\leavevmode
       \large \bfseries #1\hfil \hb@xt@\@pnumwidth{\hss #2}}\par
       \nobreak
         \global\@nobreaktrue
         \everypar{\global\@nobreakfalse\everypar{}}%
    \endgroup
  \fi}
\newcommand*\l@chapter[2]{%
  \ifnum \c@tocdepth >\m@ne
    \addpenalty{-\@highpenalty}%
    \vskip 1.0em \@plus\p@
    \setlength\@tempdima{1.5em}%
    \begingroup
      \parindent \z@ \rightskip \@pnumwidth
      \parfillskip -\@pnumwidth
      \leavevmode \bfseries
      \advance\leftskip\@tempdima
      \hskip -\leftskip
      #1\nobreak\hfil \nobreak\hb@xt@\@pnumwidth{\hss #2}\par
      \penalty\@highpenalty
    \endgroup
  \fi}
\newcommand*\l@section{\@dottedtocline{1}{1.5em}{2.3em}}
\newcommand*\l@subsection{\@dottedtocline{2}{3.8em}{3.2em}}
\newcommand*\l@subsubsection{\@dottedtocline{3}{7.0em}{4.1em}}
\newcommand*\l@paragraph{\@dottedtocline{4}{10em}{5em}}
\newcommand*\l@subparagraph{\@dottedtocline{5}{12em}{6em}}
\newcommand\listoffigures{%
    \if@twocolumn
      \@restonecoltrue\onecolumn
    \else
      \@restonecolfalse
    \fi
    \chapter*{\listfigurename}%
      \@mkboth{\MakeUppercase\listfigurename}%
              {\MakeUppercase\listfigurename}%
    \@starttoc{lof}%
    \if@restonecol\twocolumn\fi
    }
\newcommand*\l@figure{\@dottedtocline{1}{1.5em}{2.3em}}
\newcommand\listoftables{%
    \if@twocolumn
      \@restonecoltrue\onecolumn
    \else
      \@restonecolfalse
    \fi
    \chapter*{\listtablename}%
      \@mkboth{%
          \MakeUppercase\listtablename}%
         {\MakeUppercase\listtablename}%
    \@starttoc{lot}%
    \if@restonecol\twocolumn\fi
    }
\let\l@table\l@figure
\newdimen\bibindent
\setlength\bibindent{1.5em}
\newenvironment{thebibliography}[1]
     {\chapter*{\bibname}%
      \@mkboth{\MakeUppercase\bibname}{\MakeUppercase\bibname}%
      \list{\@biblabel{\@arabic\c@enumiv}}%
           {\settowidth\labelwidth{\@biblabel{#1}}%
            \leftmargin\labelwidth
            \advance\leftmargin\labelsep
            \@openbib@code
            \usecounter{enumiv}%
            \let\p@enumiv\@empty
            \renewcommand\theenumiv{\@arabic\c@enumiv}}%
      \sloppy
      \clubpenalty4000
      \@clubpenalty \clubpenalty
      \widowpenalty4000%
      \sfcode`\.\@m}
     {\def\@noitemerr
       {\@latex@warning{Empty `thebibliography' environment}}%
      \endlist}
\newcommand\newblock{\hskip .11em\@plus.33em\@minus.07em}
\let\@openbib@code\@empty
\newenvironment{theindex}
               {\if@twocolumn
                  \@restonecolfalse
                \else
                  \@restonecoltrue
                \fi
                \twocolumn[\@makeschapterhead{\indexname}]%
                \@mkboth{\MakeUppercase\indexname}%
                        {\MakeUppercase\indexname}%
                \thispagestyle{plain}\parindent\z@
                \parskip\z@ \@plus .3\p@\relax
                \columnseprule \z@
                \columnsep 35\p@
                \let\item\@idxitem}
               {\if@restonecol\onecolumn\else\clearpage\fi}
\newcommand\@idxitem{\par\hangindent 40\p@}
\newcommand\subitem{\@idxitem \hspace*{20\p@}}
\newcommand\subsubitem{\@idxitem \hspace*{30\p@}}
\newcommand\indexspace{\par \vskip 10\p@ \@plus5\p@ \@minus3\p@\relax}
\renewcommand\footnoterule{%
  \kern-3\p@
  \hrule\@width.4\columnwidth
  \kern2.6\p@}
\@addtoreset{footnote}{chapter}
\newcommand\@makefntext[1]{%
    \parindent 1em%
    \noindent
    \hb@xt@1.8em{\hss\@makefnmark}#1}
\newcommand\contentsname{TABLE OF CONTENTS}
\newcommand\listfigurename{LIST OF FIGURES}
\newcommand\listtablename{LIST OF TABLES}
\newcommand\bibname{REFERENCES}
\newcommand\indexname{INDEX}
\newcommand\figurename{Figure}
\newcommand\tablename{Table}
\newcommand\partname{PART}
\newcommand\chaptername{CHAPTER}
\newcommand\appendixname{APPENDIX}
\newcommand\abstractname{ABSTRACT}
\def\today{\ifcase\month\or
  January\or February\or March\or April\or May\or June\or
  July\or August\or September\or October\or November\or December\fi
  \space\number\day, \number\year}
\setlength\columnsep{10\p@}
\setlength\columnseprule{0\p@}
\pagestyle{plain}
\pagenumbering{arabic}


\endinput
