package com.payneteasy.yaml2json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.snakeyaml.engine.v2.nodes.*;

public class Yaml2GsonConverter {

    private final IWarningListener listener;

    public Yaml2GsonConverter() {
        this(aNode -> {});
    }

    public Yaml2GsonConverter(IWarningListener listener) {
        this.listener = listener;
    }

    public JsonObject convertToJson(MappingNode aNode) {
        return convertToJson(new JsonObject(), aNode);
    }

    private JsonObject convertToJson(JsonObject aObject, MappingNode aNode) {
        for (NodeTuple tuple : aNode.getValue()) {

            Node keyNode = tuple.getKeyNode();
            if(keyNode.getNodeType() != NodeType.SCALAR) {
                listener.nodeIsNotScalar(keyNode);
                continue;
            }

            String name      = ((ScalarNode) keyNode).getValue();
            Node   valueNode = tuple.getValueNode();

            aObject.add(name, convertAny(valueNode));

        }
        return aObject;
    }

    private JsonArray convertSequence(Node aNode) {
        SequenceNode sequenceNode = (SequenceNode) aNode;
        JsonArray array = new JsonArray();
        for (Node node : sequenceNode.getValue()) {
            array.add(convertAny(node));
        }
        return array;
    }

    private JsonObject convertMapping(Node aNode) {
        MappingNode mappingNode = (MappingNode) aNode;
        return convertToJson(new JsonObject(), mappingNode);
    }

    private JsonPrimitive convertScalar(Node aNode) {
        ScalarNode scalarNode = (ScalarNode) aNode;
        return new JsonPrimitive(scalarNode.getValue());
    }

    private JsonElement convertAny(Node aValueNode) {
        switch (aValueNode.getNodeType()) {
            case SCALAR:
                return convertScalar(aValueNode);

            case MAPPING:
                return convertMapping(aValueNode);

            case SEQUENCE:
                return convertSequence(aValueNode);

            case ANCHOR:
                throw new IllegalStateException("Anchor node type " + aValueNode);

            default:
                throw new IllegalStateException("Unknown node type " + aValueNode.getNodeType());
        }
    }
}
