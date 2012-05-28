package com.okkam.uima.tutorial.annotator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import com.okkam.uima.tutorial.ProductNumber;

public class ProductNumberAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		String txt = aJCas.getDocumentText();
		Pattern UniverseProductNumbers = Pattern.compile("" +
				"\\b[U][A-Z][A-Z]-\\d\\d\\d\\d\\d\\d");
		Matcher matcher = UniverseProductNumbers.matcher(txt);
		int pos = 0;
		while(matcher.find(pos)){
			ProductNumber productNumberAnnotation = new ProductNumber(aJCas);
			productNumberAnnotation.setProductLine("universe");
			productNumberAnnotation.setBegin(matcher.start());
			productNumberAnnotation.setEnd(matcher.end());
			
			productNumberAnnotation.addToIndexes();
			pos = matcher.end();
		}
		Pattern BeyondProductNumbers = Pattern.compile("" +
				"\\b[B][A-Z][A-Z]-\\d\\d\\d\\d");
		matcher = BeyondProductNumbers.matcher(txt);
		pos = 0;
		while (matcher.find(pos)){
			ProductNumber productNumberAnnotation = new ProductNumber(aJCas);
			productNumberAnnotation.setProductLine("Beyond");
			productNumberAnnotation.setBegin(matcher.start());
			productNumberAnnotation.setEnd(matcher.end());
			
			productNumberAnnotation.addToIndexes();
			pos = matcher.end();
		}
	}

}
