package br.com.mediahub.engine.utilities;

import br.com.mediahub.engine.content.MediaContent;

public class TimeCalculator {

    private int accumulatedTime = 0;

    public int getAccumulatedTime() {
        return accumulatedTime;
    }

    // Adds the duration of any content to the accumulator
    public void addContent(MediaContent content) {
        System.out.println("Adicionando duração em minutos de " + content);
        this.accumulatedTime += content.getDurationInMinutes();
    }
}
