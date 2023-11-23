#version 330 core

out vec4 FragColor;

// Function to generate a random value between 0 and 1
float random(vec2 st) {
    return fract(sin(dot(st.xy, vec2(12.9898, 78.233))) * 43758.5453123);
}

// Function to create a simple procedural pattern
float pattern(vec2 st) {
    return smoothstep(0.2, 0.25, sin(st.x * 10.0) * cos(st.y * 10.0) + random(st));
}

void main() {
    vec2 uv = gl_FragCoord.xy / resolution.xy;
    
    // Apply the procedural pattern
    float color = pattern(uv);

    FragColor = vec4(vec3(color), 1.0);
}
