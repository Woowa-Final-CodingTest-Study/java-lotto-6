package lotto.provider;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.*;

public class LottoProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                arguments(ErrorMessage.LOTTO_INPUT_LENGTH_MUST_6,new String[]{"8000", "1,2,3,4,5,6,7"}),
                arguments(ErrorMessage.INPUT_MUST_NUMBER, new String[]{"8000", "1,2,3,4,5,a"}),
                arguments(ErrorMessage.LOTTO_NUMBER_MUST_WITHIN_RANGE, new String[]{"8000", "0,2,3,4,5,6"}),
                arguments(ErrorMessage.LOTTO_NUMBER_MUST_WITHIN_RANGE, new String[]{"8000", "1,2,3,4,5,46"}),
                arguments(ErrorMessage.LOTTO_NUMBER_MUST_NOT_DUPLICATED, new String[]{"8000", "1,2,3,4,5,5"}),
                arguments(ErrorMessage.INPUT_MUST_NUMBER, new String[]{"8000", "1,2,3,4,5,6", "a"}),
                arguments(ErrorMessage.LOTTO_NUMBER_MUST_WITHIN_RANGE, new String[]{"8000", "1,2,3,4,5,6", "0"}),
                arguments(ErrorMessage.LOTTO_NUMBER_MUST_WITHIN_RANGE, new String[]{"8000", "1,2,3,4,5,6", "46"}),
                arguments(ErrorMessage.LOTTO_NUMBER_MUST_NOT_DUPLICATED, new String[]{"8000", "1,2,3,4,5,6", "1"})
        );
    }
}
