package org.commons.hive.utils

import java.text.Normalizer
import org.apache.hadoop.hive.ql.exec.UDF

class NormalizerUnicodeUDF extends UDF {
  def evaluate(input: String, form: String): String = {
    val normalizeForm = form match {
      case "NFD" => Normalizer.Form.NFD
      case "NFC" => Normalizer.Form.NFC
      case "NFKC" => Normalizer.Form.NFKC
      case "NFKD" => Normalizer.Form.NFKD
      case _ => Normalizer.Form.NFC  
    }

    Normalizer.normalize(input, normalizeForm).replaceAll("\\p{InCombiningDiacriticalMarks}+","")
  }
}
