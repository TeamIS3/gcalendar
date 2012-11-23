DOCS := report.tex finalReport.tex
PDFS := $(DOCS:%.tex=%.pdf)

all: $(PDFS)

%.pdf: %.tex
	pdflatex $<
	pdflatex $<
	
clean:
	rm -f *.log *.aux *.toc *.out
	rm -f *.bbl *.blg
	rm -f $(PDFS)
