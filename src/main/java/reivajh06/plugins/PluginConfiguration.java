package reivajh06.plugins;

public record PluginConfiguration(Difficulty difficulty, long moveTimeMs) {

	public enum Difficulty {
		EASY,
		MEDIUM,
		HARD,
		MAX
	}
}
