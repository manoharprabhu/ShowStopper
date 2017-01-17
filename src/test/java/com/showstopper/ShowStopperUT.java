package com.showstopper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by manoharprabhu on 1/17/2017.
 */
@RunWith(JUnit4.class)
public class ShowStopperUT {
    private boolean matchShow(Show show, String name, int seasonNumber, int episodeNumber, String extension) {
        System.out.println(show);
        return name.equals(show.getName())
                && seasonNumber == show.getSeasonNumber()
                && episodeNumber == show.getEpisodeNumber()
                && extension.equals(show.getExtension());
    }

    @Test(timeout = 1000)
    public void test1() {
        Assert.assertTrue(matchShow(ShowStopper.identify("Black.Mirror.S01E03.HDTV.mp4"),
                "Black Mirror",
                1,
                3,
                "mp4")
        );
    }

    @Test(timeout = 1000)
    public void test2() {
        Assert.assertTrue(matchShow(ShowStopper.identify("How.I.Met.Your.Mother.S10E12.HDTV.mkv"),
                "How I Met Your Mother",
                10,
                12,
                "mkv")
        );
    }

    @Test(timeout = 1000)
    public void test3() {
        Assert.assertTrue(matchShow(ShowStopper.identify("The.Number.23.S1E2.HDTV.mkv"),
                "The Number 23",
                1,
                2,
                "mkv")
        );
    }

    @Test(timeout = 1000)
    public void test4() {
        Assert.assertTrue(matchShow(ShowStopper.identify("the-big-bang-theory-s05-e03.mp4"),
                "the big bang theory",
                5,
                3,
                "mp4")
        );
    }

    @Test(timeout = 1000)
    public void test5() {
        Assert.assertTrue(matchShow(ShowStopper.identify("the-big-bangthe-big-bangthe-big-bangthe-big-bang-theory-s05-e03-HDTV-LOL.mp4"),
                "the big bangthe big bangthe big bangthe big bang theory",
                5,
                3,
                "mp4")
        );
    }

    @Test(timeout = 1000)
    public void test6() {
        Assert.assertTrue(matchShow(ShowStopper.identify("dexter.mp4"),
                "dexter",
                0,
                0,
                "mp4")
        );
    }

    @Test(timeout = 1000)
    public void test7() {
        Assert.assertTrue(matchShow(ShowStopper.identify("Dexter S06 E02 - BRRip - x264 - AC3 5.1 -={SPARROW}=-.mkv"),
                "Dexter",
                6,
                2,
                "mkv")
        );
    }

    @Test(timeout = 1000)
    public void test8() {
        Assert.assertTrue(matchShow(ShowStopper.identify("Dexter.S07E02.HDTV.x264-EVOLVE.mp4"),
                "Dexter",
                7,
                2,
                "mp4")
        );
    }

    @Test(timeout = 1000)
    public void test9() {
        Assert.assertTrue(matchShow(ShowStopper.identify("How I Met Your Mother S06E01 Big Days (1080p x265 Joy).mkv"),
                "How I Met Your Mother",
                6,
                1,
                "mkv")
        );
    }

    @Test(timeout = 1000)
    public void test10() {
        Assert.assertTrue(matchShow(ShowStopper.identify("House.M.D.S07E03.720p.5.1Ch.BluRay.ReEnc-DeeJayAhmed.mkv"),
                "House M D",
                7,
                3,
                "mkv")
        );
    }

    @Test(timeout = 1000)
    public void test11() {
        Assert.assertTrue(matchShow(ShowStopper.identify("breaking bad s04e04 720p brrip sujaidr.mkv"),
                "breaking bad",
                4,
                4,
                "mkv")
        );
    }
}