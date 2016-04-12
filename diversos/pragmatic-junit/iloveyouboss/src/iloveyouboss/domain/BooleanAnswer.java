package iloveyouboss.domain;

class BooleanAnswer {

  private final int     questionId;
  private final boolean value;

  BooleanAnswer(final int questionId, final boolean value) {
    this.questionId = questionId;
    this.value = value;
  }

  boolean getValue() {
    return this.value;
  }

  int getQuestionId() {
    return this.questionId;
  }
}
