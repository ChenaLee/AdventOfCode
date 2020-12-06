package advent2020.chenalee.day06;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
class TravelGroup {
    private final List<CustomDeclarationForm> customDeclarationForms;

    CustomDeclarationForm unionCustomDeclarationForm() {
        String combinedYesAnswers = customDeclarationForms.stream()
                .map(customDeclarationForm -> customDeclarationForm.getYesAnswers().split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.joining());
        return new CustomDeclarationForm(combinedYesAnswers);
    }

    CustomDeclarationForm intersectionCustomDeclarationForm() {
        List<String> combinedYesAnswers = customDeclarationForms.stream()
                .map(customDeclarationForm -> customDeclarationForm.getYesAnswers().split(""))
                .flatMap(Arrays::stream)
                .sorted()
                .collect(Collectors.toList());

        String currentAnswer = "";
        int currentAnswerCount = 0;
        List<String> intersectionYesAnswers = new ArrayList<>();
        for (String yesAnswer : combinedYesAnswers) {
            if (yesAnswer.equals(currentAnswer)) {
                currentAnswerCount++;
            } else {
                currentAnswer = yesAnswer;
                currentAnswerCount = 1;
            }

            if (currentAnswerCount == customDeclarationForms.size()) {
                intersectionYesAnswers.add(currentAnswer);
            }
        }
        return new CustomDeclarationForm(String.join("", intersectionYesAnswers));
    }
}
