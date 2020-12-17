package week08.d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    @Test
    void trainerWithGoodMoodTest() {
        Trainer trainer = new Trainer(new GoodMood());
        assertEquals(5, trainer.giveMark());
    }

    @Test
    void trainerWithBadMoodTest() {
        Trainer trainer = new Trainer(new BadMood());
        assertEquals(3, trainer.giveMark());
    }

}