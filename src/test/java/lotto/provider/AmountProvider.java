package lotto.provider;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.*;

public class AmountProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                arguments(ErrorMessage.INPUT_MUST_NUMBER, "1000j"),
                arguments(ErrorMessage.INPUT_MUST_NUMBER, "1000 "),
                arguments(ErrorMessage.INPUT_MUST_NUMBER, " "),
                arguments(ErrorMessage.AMOUNT_MUST_POSITIVE, "-1000"),
                arguments(ErrorMessage.AMOUNT_MUST_POSITIVE, "-1"),
                arguments(ErrorMessage.AMOUNT_MUST_POSITIVE, "0"),
                arguments(ErrorMessage.AMOUNT_MUST_DIVISIBLE, "1"),
                arguments(ErrorMessage.AMOUNT_MUST_DIVISIBLE, "1001"),
                arguments(ErrorMessage.AMOUNT_MUST_DIVISIBLE, "10100")
        );
    }
}
