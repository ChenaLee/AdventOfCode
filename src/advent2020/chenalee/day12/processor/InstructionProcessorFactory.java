package advent2020.chenalee.day12.processor;

import java.util.HashMap;
import java.util.Map;

public class InstructionProcessorFactory implements IInstructionProcessorFactory{
    private static ForwardInstructionProcessor forwardProcessor = new ForwardInstructionProcessor();
    private static LeftInstructionProcessor leftProcessor = new LeftInstructionProcessor();
    private static RightInstructionProcessor rightProcessor = new RightInstructionProcessor();
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
