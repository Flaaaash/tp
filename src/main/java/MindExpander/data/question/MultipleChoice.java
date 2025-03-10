package mindexpander.data.question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MultipleChoice extends Question {
    private final List<String> options;

    public MultipleChoice(String question, String answer, List<String> options) {
        super(question, answer, QuestionType.MCQ);
        this.options = new ArrayList<>(options);
    }

    public MultipleChoice editOption(int index, String newOption) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i += 1) {
            list.add(options.get(i));
        }
        list.set(index, newOption);
        return new MultipleChoice(question, answer, list);
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        return answer.equalsIgnoreCase(userAnswer.trim());
    }

    @Override
    public String showQuestion() {
        List<String> shuffledOptions = new ArrayList<>(options);
        Collections.shuffle(shuffledOptions);
        StringBuilder sb = new StringBuilder();
        sb.append("MCQ: ").append(question).append("\n");
        for (int i = 0; i < shuffledOptions.size(); i += 1) {
            sb.append((char) ('A' + i)).append(". ").append(shuffledOptions.get(i)).append("\n");
        }
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MCQ: ").append(question).append(" [Answer: A]").append("\n");
        for (int i = 0; i < options.size(); i += 1) {
            sb.append((char) ('A' + i)).append(". ").append(options.get(i)).append("\n");
        }
        return sb.toString();
    }
}
