package StrwbryDev.scoreSync.utility;

import StrwbryDev.scoreSync.ScoreSync;

public class Config
{
    //method to reload config
    public static void reloadConfig() {
        ScoreSync.getPlugin().reloadConfig();
    }

    //methods to get Last Player Standing config values
    public static int getWinThresholdTier1()
    {
        return ScoreSync.getPlugin().getConfig().getInt("last-player-standing.win-threshold-1");
    }
    public static int getWinThresholdTier2()
    {
        return ScoreSync.getPlugin().getConfig().getInt("last-player-standing.win-threshold-2");
    }
    public static int getWinThresholdTier3()
    {
        return ScoreSync.getPlugin().getConfig().getInt("last-player-standing.win-threshold-3");
    }
    public static int getLastAlive()
    {
        return ScoreSync.getPlugin().getConfig().getInt("last-player-standing.points-awarded-last-alive");
    }
    public static int getLPSPointsAwardedTier1()
    {
        return ScoreSync.getPlugin().getConfig().getInt("last-player-standing.points-awarded-1");
    }
    public static int getLPSPointsAwardedTier2()
    {
        return ScoreSync.getPlugin().getConfig().getInt("last-player-standing.points-awarded-2");
    }
    public static int getLPSPointsAwardedTier3()
    {
        return ScoreSync.getPlugin().getConfig().getInt("last-player-standing.points-awarded-3");
    }


}
