package com.sdsmdg.flingit.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by rahul on 12/12/16.
 */

public class Line {
    private final static String TAG = Line.class.getSimpleName();
    private boolean isShow = false;
    private Vector3 draggedVector;
    private float gap;
    private float totalLength;
    private Body body;
    private int lineWidth;

    public Line(Body body, int width) {
        this.body = body;
        this.lineWidth = width;
    }


    public void render(ShapeRenderer renderer) {
        if (isShow) {
            initializeGap();
            //drawing straight line
            renderer.begin();
            renderer.set(ShapeRenderer.ShapeType.Filled);
            Gdx.graphics.getGL20().glEnable(GL20.GL_BLEND);
            renderer.setColor((float) 66.0 / 255, (float) 66.0 / 255, (float) 100.0 / 255, 0.5f);
            renderer.rectLine(body.getPosition().x, body.getPosition().y, body.getFlickDragged().x,
                    body.getFlickDragged().y, lineWidth);
            renderer.end();
        }
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public Vector3 getDraggedVector() {
        return draggedVector;
    }

    public void setDraggedVector(Vector3 draggedVector) {
        this.draggedVector = draggedVector;
    }

    public void initializeGap() {
        totalLength = draggedVector.len();
        gap = totalLength / 8;
    }
}
