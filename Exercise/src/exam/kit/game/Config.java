package exam.kit.game;

import exam.kit.exceptions.InvalidArgumentException;
import exam.kit.exceptions.MalformedConfigException;
import exam.kit.game.action.Action;
import exam.kit.util.general.FileOperation;
import exam.kit.util.system.ConfigParser;


import java.util.HashMap;
import java.util.List;

/**
 * Holds all the data from the config file.
 * @author uepiy
 */

public class Config {
    private HashMap<String, Action> actionMap;
    private HashMap<String, MonsterTemplate> monsterTemplateMap;

    /**
     * Constructs a Config object from the specified file.
     * Config holds all the data from the file as initialized objects.
     * @param fileName name/path of the file to read from
     * @throws MalformedConfigException if the config file is not formatted correctly
     * @throws InvalidArgumentException if the config file cannot be read
     */
    public Config(String fileName) throws MalformedConfigException, InvalidArgumentException {
        List<String> configLines = FileOperation.readLinesFromFile(fileName);
        this.actionMap = ConfigParser.parseActions(configLines);
        this.monsterTemplateMap = ConfigParser.parseMonsters(configLines, actionMap);
        printConfig(configLines);
        printLoadedData(actionMap.size(), monsterTemplateMap.size());
    }
    private void printConfig(List<String> configLines) {
        for (String line : configLines) {
            System.out.println(line);
        }
    }
    private void printLoadedData(int actionSize, int monsterSize) {
        System.out.println("Loaded " + actionSize + " actions, " + monsterSize + " monsters.");
    }
    /**
     * Returns the MonsterTemplates extracted from the config file.
     * @return list of MonsterTemplates
     */
    public List<MonsterTemplate> getMonsterTemplates() {
        return List.copyOf(monsterTemplateMap.values());
    }
}
