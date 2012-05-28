package et.aqa.uima;

import java.io.File;
import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.Type;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.util.FileUtils;
import org.apache.uima.util.XMLInputSource;

/**
 * A simple java class with a main method to print different Ethiopic dates
 * found and annotated in Amharic document using the AmharicDateAnnotator class
 * 
 * @author seidm
 * 
 */
public class AmharicDateFinder {

	public static void main(String... args) {
		try {
			File taeDescriptor = new File("descriptors/AmharicDateAnnotatorAEDescriptor.xml");
			File inputFile = new File("data/document1.txt");
			XMLInputSource in = new XMLInputSource(taeDescriptor);
			ResourceSpecifier specifier = UIMAFramework.getXMLParser().parseResourceSpecifier(in);
			AnalysisEngine tae = UIMAFramework.produceAnalysisEngine(specifier);
			CAS tcas = tae.newCAS();

			String document = normalizeDocument(
					FileUtils.file2String(inputFile, "UTF-8"));
			tcas.setDocumentText(document);
			tae.process(tcas);
			printEthiopicDates(tcas);
			tae.destroy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * print different Ethiopic dates found in a document
	 * 
	 * @param tcas
	 */
	public static void printEthiopicDates(CAS tcas) {
		Type dateType = tcas.getTypeSystem().getType("et.aqa.uima.AmharicDate");
		System.out.println("Type is " + dateType.getName() + ".");
		System.out.println("");
		FSIterator iter = tcas.getAnnotationIndex(dateType).iterator();
		System.out.println("The Ethiopic Date found\t\tAnotation Begins\t\tAnotation Ends \tDateType");
		while (iter.isValid()) {
			FeatureStructure fs = iter.get();
			AmharicDate annot = (AmharicDate) fs;
			String coveredText = annot.getCoveredText();
			System.out.println(coveredText  + "\t\t\t\t"+
					annot.getBegin()+ " \t\t \t\t" + annot.getEnd()+ "\t\t" + annot.getDate());
			
			iter.moveToNext();
		}

	}

	/**
	 * Normalize Amharic documents based on different orthographic features
	 */
	private static String normalizeDocument(String doc) {
		doc = doc.replace("ሃ", "ሀ").replace("ሐ", "ሀ").replace("ሓ", "ሀ").replace("ኅ", "ሀ").replace("ኃ", "ሀ")
				 .replace("ኋ", "ኋ").replace("ሗ", "ኋ").replace("ኁ", "ሁ").replace("ኂ", "ሂ").replace("ኄ", "ሄ")
				 .replace("ኅ", "ህ").replace("ኆ", "ሆ").replace("ሑ", "ሁ").replace("ሒ", "ሂ").replace("ሔ", "ሄ")
				 .replace("ሕ", "ህ").replace("ሖ", "ሆ").replace("ሠ", "ሰ").replace("ሡ", "ሱ").replace("ሢ", "ሲ")
				 .replace("ሣ", "ሳ").replace("ሤ", "ሴ").replace("ሥ", "ስ").replace("ሦ", "ሶ").replace("ሼ", "ሸ")
				 .replace("ቼ", "ቸ").replace("ዬ", "የ").replace("ዲ", "ድ").replace("ጄ", "ጀ").replace("ጸ", "ፀ")
				 .replace("ጹ", "ፁ").replace("ጺ", "ፂ").replace("ጻ", "ፃ").replace("ጼ", "ፄ").replace("ጽ", "ፅ")
				 .replace("ጾ", "ፆ").replace("ዉ", "ው").replace("ዴ", "ደ").replace("ቺ", "ች").replace("ዪ", "ይ")
				 .replace("ጪ", "ጭ").replace("ዓ", "አ").replace("ዑ", "ኡ").replace("ዒ", "ኢ").replace("ዐ", "አ")
				 .replace("ኣ", "አ").replace("ዔ", "ኤ").replace("ዕ", "እ").replace("ዖ", "ኦ").replace("ኚ", "ኝ")
				 .replace("ሺ", "ሽ");
		return doc;
	}
}
