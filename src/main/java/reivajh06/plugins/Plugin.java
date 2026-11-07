package reivajh06.plugins;

/**
 * PLUGIN INTERFACE FROM THE ARCHCHESS PLUGINS SUPPORT
 * <p>
 * These plugins are exclusively used as chess engines to allow a uniform communication between different
 * chess engines, as not all of them follow a specific commands/execution rules to follow. AI local models or even AI
 * API are also part of this plugin definition.
 * <p>
 * This interface defines the contract from which the plugins can establish a simple communication with the Archchess backend.
 * <p>
 * Note that this contract only defines basic methods for configuration and moves execution.
 *
 */
public interface Plugin {

	enum PluginType {
		CPU,
		AI
	}

	String name();

	PluginType type();

	void start();

	boolean isReady();

	/**
	 * Basic method that Archchess uses to request a move from the plugin
	 * @param fen Forsyth–Edwards Notation which defines the basic characteristics of the current state of a chess match
	 * @return a mapped response
	 */
	PluginResponse requestMove(String fen);

	/**
	 * Method that Archchess uses to send a specific configuration for the plugin. Read the PluginConfiguration class for
	 * more details.
	 *
	 * @param configuration Basic configuration from which the chess engine/ ai adapts its calculations
	 * @return true if the configuration is accepted, false otherwise. In general, the plugins would always respond true, as these
	 * parameters can be technically ignored
	 */
	boolean sendParameters(PluginConfiguration configuration);
}
