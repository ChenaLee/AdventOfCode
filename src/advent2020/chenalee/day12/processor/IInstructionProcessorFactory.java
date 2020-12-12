package advent2020.chenalee.day12.processor;

public interface IInstructionProcessorFactory {
    InstructionProcessor getProcessor(String type);
}
