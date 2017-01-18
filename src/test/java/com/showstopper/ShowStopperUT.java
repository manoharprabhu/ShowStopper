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
    private void matchShow(Show show, String name, int seasonNumber, int episodeNumber, String extension) {
        System.out.println("====");
        System.out.println("Expected: " + name + " , " + seasonNumber + " , " + episodeNumber + " , " + extension);
        System.out.println("Actual: " + show.toString());
        System.out.println("====");
        Assert.assertEquals(name, show.getName());
        Assert.assertEquals(seasonNumber, show.getSeasonNumber());
        Assert.assertEquals(episodeNumber, show.getEpisodeNumber());
        Assert.assertEquals(extension, show.getExtension());
    }

    @Test(timeout = 1000)
    public void test1() {
        matchShow(ShowStopper.identify("Black.Mirror.S01E03.HDTV.mp4"),
                "Black Mirror",
                1,
                3,
                "mp4");
    }

    @Test(timeout = 1000)
    public void test2() {
        matchShow(ShowStopper.identify("How.I.Met.Your.Mother.S10E12.HDTV.mkv"),
                "How I Met Your Mother",
                10,
                12,
                "mkv");
    }

    @Test(timeout = 1000)
    public void test3() {
        matchShow(ShowStopper.identify("The.Number.23.S1E2.HDTV.mkv"),
                "The Number 23",
                1,
                2,
                "mkv");
    }

    @Test(timeout = 1000)
    public void test4() {
        matchShow(ShowStopper.identify("the-big-bang-theory-s05-e03.mp4"),
                "the big bang theory",
                5,
                3,
                "mp4");
    }

    @Test(timeout = 1000)
    public void test5() {
        matchShow(ShowStopper.identify("the-big-bangthe-big-bangthe-big-bangthe-big-bang-theory-s05-e03-HDTV-LOL.mp4"),
                "the big bangthe big bangthe big bangthe big bang theory",
                5,
                3,
                "mp4");
    }

    @Test(timeout = 1000)
    public void test6() {
        matchShow(ShowStopper.identify("dexter.mp4"),
                "dexter",
                0,
                0,
                "mp4");
    }

    @Test(timeout = 1000)
    public void test7() {
        matchShow(ShowStopper.identify("Dexter S06 E02 - BRRip - x264 - AC3 5.1 -={SPARROW}=-.mkv"),
                "Dexter",
                6,
                2,
                "mkv");
    }

    @Test(timeout = 1000)
    public void test8() {
        matchShow(ShowStopper.identify("Dexter.S07E02.HDTV.x264-EVOLVE.mp4"),
                "Dexter",
                7,
                2,
                "mp4");
    }

    @Test(timeout = 1000)
    public void test9() {
        matchShow(ShowStopper.identify("How I Met Your Mother S06E01 Big Days (1080p x265 Joy).mkv"),
                "How I Met Your Mother",
                6,
                1,
                "mkv");
    }

    @Test(timeout = 1000)
    public void test10() {
        matchShow(ShowStopper.identify("House.M.D.S07E03.720p.5.1Ch.BluRay.ReEnc-DeeJayAhmed.mkv"),
                "House M D",
                7,
                3,
                "mkv");
    }

    @Test(timeout = 1000)
    public void test11() {
        matchShow(ShowStopper.identify("breaking bad s04e04 720p brrip sujaidr.mkv"),
                "breaking bad",
                4,
                4,
                "mkv");
    }

    @Test(timeout = 1000)
    public void test12() {
        matchShow(ShowStopper.identify("singletext"),
                "singletext",
                0,
                0,
                "");
    }

    @Test(timeout = 1000)
    public void test13() {
        matchShow(ShowStopper.identify("homealone.mp4"),
                "homealone",
                0,
                0,
                "mp4");
    }

    @Test(timeout = 1000)
    public void test14() {
        matchShow(ShowStopper.identify("inglorious_basterds_movie.mkv"),
                "inglorious basterds movie",
                0,
                0,
                "mkv");
    }

    @Test(timeout = 1000)
    public void test15() {
        matchShow(ShowStopper.identify("Mr.Robot.S02E05.INTERNAL.HDTV.x264-FUM[ettv].mp4"),
                "Mr Robot",
                2,
                5,
                "mp4");
    }
}
