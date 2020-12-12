package advent2020.chenalee.day12.processor.waypointProcessor;

import advent2020.chenalee.day12.processor.EastInstructionProcessor;
import advent2020.chenalee.day12.processor.IInstructionProcessorFactory;
import advent2020.chenalee.day12.processor.InstructionProcessor;
import advent2020.chenalee.day12.processor.NorthInstructionProcessor;
import advent2020.chenalee.day12.processor.SouthInstructionProcessor;
import advent2020.chenalee.day12.processor.WestInstructionProcessor;

import java.util.HashMap;
import java.util.Map;

public class WaypointInstructionProcessorFactory implements IInstructionProcessorFactory {
    private static WaypointForwardInstructionProcessor forwardProcessor = new WaypointForwardInstructionProcessor();
    private static WaypointLeftInstructionProcessor leftProcessor = new WaypointLeftInstructionProcessor();
    private static WaypointRightInstructionProcessor rightProcessor = new WaypointRightInstructionProcessor();
    private static EastInstructionProcessor eastProcessor = new EastInstructionProcessor();
    private static WestInstructionProcessor westProcessor = new WestInstructionProcessor();
    private static NorthInstructionProcessor northProcessor = new NorthInstructionProcessor();
    private static SouthInstructionProcessor southProcessor = new SouthInstructionProcessor();

    private static Map<String, InstructionProcessor> processorMap = new HashMap<>();

    static {
        processorMap.put("F", forwardProcessor);
        processorMap.put("L", leftProcessor);
        processorMap.put("R", rightProcessor);
        processorMap.put("E", eastProcessor);
        processorMap.put("W", westProcessor);
        processorMap.put("N", northProcessor);
        processorMap.put("S", southProcessor);
    }

    public InstructionProcessor getProcessor(String type) {
        return processorMap.get(type);
    }
}
