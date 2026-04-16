package suga.engine.game.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicGameObjectTest {

    /**
     * The add attribute should make the attribute present in the BasicGameObject and forbid overwriting inherent
     * properties.
     */
    @Test
    void addAttribute () {
        BasicGameObject obj = new BasicGameObject();
        obj.addAttribute(null, "POSITION");
        // todo: implement.
    }

    @Test
    void removeAttribute () { // TODO: Implement
    }

    @Test
    void getAttribute () { // TODO: Implement
    }

    @Test
    void getIntAttribute () { // TODO: Implement
    }

    @Test
    void getStrAttribute () { // TODO: Implement
    }

    @Test
    void getDoubleAttribute () { // TODO: Implement
    }

    @Test
    void getVectorAttribute () { // TODO: Implement
    }
}