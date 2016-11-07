package org.scalarules.dsl.nl.grammar

import org.scalarules.dsl.core.grammar.{DslEvaluation, ListAggregationEvaluation}
import org.scalarules.engine.Evaluation

trait DslOrderedListAggregator {
  private[grammar] def toEvaluation[A : Ordering](listEvaluation: Evaluation[List[A]]): Evaluation[A]

  def van[A : Ordering](operation: DslEvaluation[List[A]]): DslEvaluation[A] = new DslEvaluation[A](operation.condition, toEvaluation(operation.evaluation))
}

// scalastyle:off object.name
object laagste extends DslOrderedListAggregator {
  private[grammar] def toEvaluation[A : Ordering](listEvaluation: Evaluation[List[A]]): Evaluation[A] = new ListAggregationEvaluation[A](listEvaluation, _.min)
}

object hoogste extends DslOrderedListAggregator {
  private[grammar] def toEvaluation[A : Ordering](listEvaluation: Evaluation[List[A]]): Evaluation[A] = new ListAggregationEvaluation[A](listEvaluation, _.max)
}
// scalastyle:on object.name

