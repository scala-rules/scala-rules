package nl.rabobank.oss.rules.dsl.core.projections

import nl.rabobank.oss.rules.dsl.core.glossaries.Glossary

object ProjectableFieldsGlossary extends Glossary {
  val ComplexFact = defineFact[ComplexObject]
  val IntFact = defineFact[Int]
  val IntFact2 = defineFact[Int]

  val ComplexFactList = defineListFact[ComplexObject]
  val StringFactList = defineListFact[String]
}
