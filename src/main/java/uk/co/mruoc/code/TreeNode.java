package uk.co.mruoc.code;

import com.squareup.javapoet.ArrayTypeName;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    private static final Logger LOGGER = LoggerFactory.getLogger(TreeNode.class);

    private TreeNode parent;
    private List<TreeNode> children = new ArrayList<>();
    private String value = "";

    public void append(char c) {
        value += c;
    }

    public String getValue() {
        return value;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void addChild(TreeNode child) {
        child.setParent(this);
        children.add(child);
    }

    public void debug() {
        LOGGER.debug("node " + this + " value " + value + " child count " + children.size() + " parent value " + getParent());
        for (TreeNode child : children) {
            child.debug();
        }
    }

    public TypeName toTypeName() {
        if (hasChildren()) {
            return ParameterizedTypeName.get(ClassName.bestGuess(value), getChildTypes());
        }
        if (hasArrayValue()) {
            return arrayValueToTypeName();
        }
        return ClassName.bestGuess(value);
    }

    private boolean hasChildren() {
        return !children.isEmpty();
    }

    private boolean hasArrayValue() {
        return value.contains("[");
    }

    private TypeName arrayValueToTypeName() {
        ClassName className = ClassName.bestGuess(value.replace("[]", ""));
        return ArrayTypeName.of(className);
    }

    private void setParent(TreeNode parent) {
        this.parent = parent;
    }

    private TypeName[] getChildTypes() {
        TypeName[] childTypes = new TypeName[children.size()];
        for (int i = 0; i < children.size(); i++) {
            childTypes[i] = children.get(i).toTypeName();
        }
        return childTypes;
    }

}
