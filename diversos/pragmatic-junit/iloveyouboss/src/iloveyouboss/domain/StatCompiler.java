package iloveyouboss.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class StatCompiler {

  private final QuestionController controller = new QuestionController();

  public Map<String, Map<Boolean, AtomicInteger>> responsesByQuestion(
      final List<BooleanAnswer> answers, final Map<Integer, String> questions) {
    final Map<String, Map<Boolean, AtomicInteger>> responses = new HashMap<>();
    answers.stream()
           .forEach(answer -> incrementHistogram(responses, answer));
    return convertHistogramIdsToText(responses, questions);
  }

  public Map<Integer, String> questionText(final List<BooleanAnswer> answers) {
    final Map<Integer, String> questions = new HashMap<>();
    answers.stream()
           .forEach(answer -> {
             if (!questions.containsKey(answer.getQuestionId())) {
               questions.put(answer.getQuestionId(),
                   controller.find(answer.getQuestionId())
                             .getText());
             }
           });
    return questions;
  }

  private Map<String, Map<Boolean, AtomicInteger>> convertHistogramIdsToText(
      final Map<String, Map<Boolean, AtomicInteger>> responses,
      final Map<Integer, String> questions) {
    final Map<String, Map<Boolean, AtomicInteger>> textResponses = new HashMap<>();
    responses.keySet()
             .stream()
             .forEach(
                 id -> textResponses.put(questions.get(id), responses.get(id)));
    return textResponses;
  }

  private void incrementHistogram(
      final Map<Integer, Map<Boolean, AtomicInteger>> responses,
      final BooleanAnswer answer) {
    final Map<Boolean, AtomicInteger> histogram = getHistogram(responses,
        answer.getQuestionId());
    histogram.get(Boolean.valueOf(answer.getValue()))
             .getAndIncrement();
  }

  private Map<Boolean, AtomicInteger> getHistogram(
      final Map<Integer, Map<Boolean, AtomicInteger>> responses, final int id) {
    Map<Boolean, AtomicInteger> histogram = null;
    if (responses.containsKey(id)) {
      histogram = responses.get(id);
    } else {
      histogram = createNewHistogram();
      responses.put(id, histogram);
    }
    return histogram;
  }

  private Map<Boolean, AtomicInteger> createNewHistogram() {
    Map<Boolean, AtomicInteger> histogram;
    histogram = new HashMap<>();
    histogram.put(Boolean.FALSE, new AtomicInteger(0));
    histogram.put(Boolean.TRUE, new AtomicInteger(0));
    return histogram;
  }
}
