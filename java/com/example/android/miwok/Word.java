package com.example.android.miwok;

/**
 * Created by danieldemarco on 3/14/18.
 * <p>
 * {@link Word} represents a vocabulary word that the user wants to learn. It contains both Miwok and default translations for the word.
 */

public class Word {

    private String miwokTranslation;
    private String defaultTranslation;
    private int imageResourceId = NO_IMAGE_RESOURCE_PROVIDED;
    private static final int NO_IMAGE_RESOURCE_PROVIDED = -1;
    private int audioResourceId =  NO_AUDIO_RESOURCE_PROVIDED;
    private static final int NO_AUDIO_RESOURCE_PROVIDED = -1;

    /**
     * Creates an instance of {@Word}  without an image
     *
     * @param defaultTranslation
     * @param miwokTranslation
     */
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {

        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.audioResourceId = audioResourceId;
    }

    /**
     * Creates an instance of {@Word} with an image
     *
     * @param defaultTranslation
     * @param miwokTranslation
     * @param imageResourceId
     */
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId, int imageResourceId) {

        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.audioResourceId = audioResourceId;
        this.imageResourceId = imageResourceId;

    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    /**
     * Get the default translation of the word.
     *
     * @return
     */
    public String getDefaultTranslation() {
        return defaultTranslation;
    }


    /**
     * Get the Miwok translation of the word.
     *
     * @return
     */
    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    /**
     * @return true if there is an image. false if not.
     */
    public boolean hasImage() {
        return imageResourceId != NO_IMAGE_RESOURCE_PROVIDED;
    }

    public int getAudioResourceId() {
        return audioResourceId;
    }
}
