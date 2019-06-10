const Identity = x => ({
    emit: () => x,
    chain: f => f(x),
    map: f => Identity(f(x)),
    inspect: () => `Identity(${x})`,
});

const IdentityOf = x => Identity(x);

const exportIdentity = {
    of: IdentityOf,
};

export { exportIdentity as Identity };
