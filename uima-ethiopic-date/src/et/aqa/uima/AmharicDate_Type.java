
/* First created by JCasGen Mon May 28 11:37:57 CEST 2012 */
package et.aqa.uima;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Mon May 28 11:37:57 CEST 2012
 * @generated */
public class AmharicDate_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (AmharicDate_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = AmharicDate_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new AmharicDate(addr, AmharicDate_Type.this);
  			   AmharicDate_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new AmharicDate(addr, AmharicDate_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = AmharicDate.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("et.aqa.uima.AmharicDate");
 
  /** @generated */
  final Feature casFeat_Date;
  /** @generated */
  final int     casFeatCode_Date;
  /** @generated */ 
  public String getDate(int addr) {
        if (featOkTst && casFeat_Date == null)
      jcas.throwFeatMissing("Date", "et.aqa.uima.AmharicDate");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Date);
  }
  /** @generated */    
  public void setDate(int addr, String v) {
        if (featOkTst && casFeat_Date == null)
      jcas.throwFeatMissing("Date", "et.aqa.uima.AmharicDate");
    ll_cas.ll_setStringValue(addr, casFeatCode_Date, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public AmharicDate_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_Date = jcas.getRequiredFeatureDE(casType, "Date", "uima.cas.String", featOkTst);
    casFeatCode_Date  = (null == casFeat_Date) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Date).getCode();

  }
}



    